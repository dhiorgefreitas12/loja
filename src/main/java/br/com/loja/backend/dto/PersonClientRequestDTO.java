package br.com.loja.backend.dto;

import org.springframework.beans.BeanUtils;

import br.com.loja.backend.entity.City;
import br.com.loja.backend.entity.Person;
import lombok.Data;

@Data
public class PersonClientRequestDTO {

    private String name;
    private String cpf;
    private String email;
    private String andress;
    private String ceṕ;
    private City city;

    public Person convert(PersonClientRequestDTO PersonClientRequestDTO) {
        Person person = new Person();
        BeanUtils.copyProperties(PersonClientRequestDTO, person);
        return person;
    }

}
