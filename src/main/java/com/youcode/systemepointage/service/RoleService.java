package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.RoleDAO;
import com.youcode.systemepointage.dao.RoleDAOImp;
import com.youcode.systemepointage.model.Role;

public class RoleService {
    private RoleDAO roleDAO;

    public RoleService() {
        this.roleDAO = new RoleDAOImp();
    }

    public void creerRole(String role) {
        roleDAO.create(Role.builder().nom(role).build());
    }

}
