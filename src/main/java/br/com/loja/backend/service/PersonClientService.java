package br.com.loja.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.backend.dto.PersonClientRequestDTO;
import br.com.loja.backend.entity.Person;
import br.com.loja.backend.repository.PersonClientRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonClientService {

    @Autowired
    PersonClientRepository personClientRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PermissionPersonService permissionPersonService;

    public Person register(PersonClientRequestDTO personClientRequestDTO) {
        Person person = new PersonClientRequestDTO().convert(personClientRequestDTO);
        person.setCreationdate(new Date());
        Person newPerson = personClientRepository.saveAndFlush(person);
        permissionPersonService.linkPersonPermissionClient(newPerson);
        Map<String, Object> properts = new HashMap<>();
        properts.put("name", newPerson.getName());
        properts.put("message", "Registro na loja realizado com sucesso!");
        emailService.send(newPerson.getEmail(), "Cadastro na Loja", properts);

        return newPerson;
    }

}
