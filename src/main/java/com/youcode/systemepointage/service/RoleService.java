package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.RoleDAO;
import com.youcode.systemepointage.dao.RoleDAOImp;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Roles;

public class RoleService {
    private RoleDAO roleDAO;

    public RoleService() {
        this.roleDAO = new RoleDAOImp();
    }

    public Role ajouterRole(String role){
        Role nouveauRole = new Role(Roles.valueOf(role));
        return roleDAO.create(nouveauRole);
    }
}
