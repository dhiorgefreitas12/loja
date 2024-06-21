package br.com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.backend.entity.State;

public interface StateRepository extends JpaRepository<State, Long> {
    
}
