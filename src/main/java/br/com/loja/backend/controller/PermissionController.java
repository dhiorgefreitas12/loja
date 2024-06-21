package br.com.loja.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.backend.entity.Permission;
import br.com.loja.backend.service.PermissionService;

@RestController
@RequestMapping("/api/permission")
@CrossOrigin
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/")
    public List<Permission> getAll() {
        return permissionService.getAll();
    }

    @PostMapping("/")
    public Permission register(@RequestBody Permission objeto) {
        return permissionService.register(objeto);
    }

    @PutMapping("/")
    public Permission update(@RequestBody Permission objeto) {
        return permissionService.update(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        permissionService.delete(id);
        return ResponseEntity.ok().build();
    }

}