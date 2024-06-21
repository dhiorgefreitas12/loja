package br.com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.backend.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
