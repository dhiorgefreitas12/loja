package br.com.loja.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.backend.entity.Person;
import br.com.loja.backend.service.PersonMenagementService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/person-menagement")
public class PersonManagementController {

    @Autowired
    PersonMenagementService personMenagementService;

    @PostMapping("/password-code")
    public String recordCode(@RequestBody Person person) {
        return personMenagementService.solicitationCoide(person.getEmail());
    }

    @PostMapping("/password-change")
    public String changePassword(@RequestBody Person person) {
        return personMenagementService.changePassword(person);
    }

}
