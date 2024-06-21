package br.com.loja.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.backend.dto.PersonClientRequestDTO;
import br.com.loja.backend.entity.Person;
import br.com.loja.backend.service.PersonClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/client")
public class PersonClientController {

    @Autowired
    PersonClientService personClientService;

    @PostMapping("/")
    public Person register(@RequestBody PersonClientRequestDTO personClientRequestDTO) {
        return personClientService.register(personClientRequestDTO);
    }

}
