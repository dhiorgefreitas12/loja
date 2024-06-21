package br.com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
