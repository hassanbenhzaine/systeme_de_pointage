package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class RoleService {
    private final GenericDAO<Role, Integer> roleDAO;

    public void creer(String role) {
        roleDAO.create(Role.builder().nom(role).build());
    }

    public Role trouverParNom(String role) {
        return roleDAO.findAll()
                .parallelStream()
                .filter(r -> r.getNom() == role)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Role introuvable"));
    }

}
