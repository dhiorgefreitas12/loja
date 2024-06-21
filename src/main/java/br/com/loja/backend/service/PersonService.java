package br.com.loja.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.backend.entity.Person;
import br.com.loja.backend.repository.PersonRepository;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getALl() {
        return personRepository.findAll();
    }

    public Person register(Person person) {
        person.setCreationdate(new Date());
        Person newPerson = personRepository.saveAndFlush(person);
        return newPerson;
    }

    public Person update(Person person) {
        person.setUpdatedate(new Date());
        return personRepository.saveAndFlush(person);
    }

    public void delete(Long id) {
        Person person = personRepository.findById(id).get();
        personRepository.delete(person);
    }

}
