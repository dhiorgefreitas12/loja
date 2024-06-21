package br.com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.backend.entity.Person;

public interface PersonClientRepository extends JpaRepository<Person, Long> {
    
}
