package br.com.loja.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.backend.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    List<Permission> findByName(String name);
}