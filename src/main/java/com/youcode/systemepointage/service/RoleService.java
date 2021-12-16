package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.RoleDAO;
import com.youcode.systemepointage.model.Role;

public class RoleService {
    private RoleDAO roleDAO;
    private static RoleService instance = null;

    public static RoleService getInstance(){
        if(instance==null){
            instance = new RoleService();
        }
        return instance;
    }

    public void creerRole(String role) {
        roleDAO.create(Role.builder().nom(role).build());
    }

    public Role trouverRole(String role) {
        return roleDAO.findByName(role).orElseThrow(() -> new RuntimeException("Role introuvable"));
    }

}
