package br.com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.backend.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
