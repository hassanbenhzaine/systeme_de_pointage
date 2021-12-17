package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.RoleDAO;
import com.youcode.systemepointage.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class RoleService {
    private final RoleDAO roleDAO;

    public void creerRole(String role) {
        roleDAO.create(Role.builder().nom(role).build());
    }

    public Role trouverRole(String role) {
        return roleDAO.findByName(role).orElseThrow(() -> new RuntimeException("Role introuvable"));
    }

}
