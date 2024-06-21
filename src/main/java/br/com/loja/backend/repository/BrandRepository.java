package br.com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.backend.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
