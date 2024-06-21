package br.com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.backend.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);

    Person findByEmailAndPasswordRecoveryCode(String email, String passwordRecoveryCode);
}
