package br.com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
