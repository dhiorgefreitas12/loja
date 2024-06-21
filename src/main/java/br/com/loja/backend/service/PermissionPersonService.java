package br.com.loja.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.backend.entity.Permission;
import br.com.loja.backend.entity.PermissionPerson;
import br.com.loja.backend.entity.Person;
import br.com.loja.backend.repository.PermissionPersonRepository;
import br.com.loja.backend.repository.PermissionRepository;

@Service
public class PermissionPersonService {

    @Autowired
    private PermissionPersonRepository permissionPersonRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public void linkPersonPermissionClient(Person person) {
        List<Permission> listPermissions = permissionRepository.findByName("cliente");
        if (listPermissions.size() > 0) {
            PermissionPerson permissionPerson = new PermissionPerson();
            permissionPerson.setPerson(person);
            permissionPerson.setPermission(listPermissions.get(0));
            permissionPerson.setCreationdate(new Date());
            permissionPersonRepository.saveAndFlush(permissionPerson);
        }
    }

}