package br.com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.loja.backend.entity.PermissionPerson;

public interface PermissionPersonRepository extends JpaRepository<PermissionPerson, Long> {

}