package br.com.loja.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.backend.entity.Person;
import br.com.loja.backend.repository.PersonRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonMenagementService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private EmailService emailService;

    public String solicitationCoide(String email) {
        Person person = personRepository.findByEmail(email);
        person.setPasswordRecoveryCode(getCodePasswordRecovery(person.getId()));
        person.setDateShippingCode(new Date());
        personRepository.saveAndFlush(person);
        emailService.avoidEmailText(person.getEmail(), "Código de recuperação de senha",
                "Olá, o seu código para recuperação de senha é o seguinte: " + person.getPasswordRecoveryCode());
        return "Código Enviado!";
    }

    public String changePassword(Person person) {
        Person personExisting = personRepository.findByEmailAndPasswordRecoveryCode(person.getEmail(),
                person.getPasswordRecoveryCode());
        if (personExisting != null) {

            Date differene = new Date(new Date().getTime() - personExisting.getDateShippingCode().getTime());

            if (differene.getTime() / 1000 < 900) {
                personExisting.setPassword(person.getPassword());
                personExisting.setPasswordRecoveryCode(null);
                personRepository.saveAndFlush(personExisting);
                return "Senha cadastrada com sucesso!";
            } else {
                return "Tempo expirado, solicite um novo codigo!";
            }
        } else {
            return "Email ou código não encontrado!";
        }

    }

    private String getCodePasswordRecovery(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
    }

}
