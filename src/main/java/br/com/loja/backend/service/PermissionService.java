package br.com.loja.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.backend.entity.Permission;
import br.com.loja.backend.repository.PermissionRepository;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }

    public Permission register(Permission objeto) {
        objeto.setCreationdate(new Date());
        Permission objetoNovo = permissionRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Permission update(Permission objeto) {
        objeto.setUpdatedate(new Date());
        return permissionRepository.saveAndFlush(objeto);
    }

    public void delete(Long id) {
        Permission objeto = permissionRepository.findById(id).get();
        permissionRepository.delete(objeto);
    }
}