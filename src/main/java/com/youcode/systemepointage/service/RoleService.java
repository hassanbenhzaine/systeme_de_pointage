package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.RoleDAO;
import com.youcode.systemepointage.dao.RoleDAOImp;

public class RoleService {
    private RoleDAO roleDAO;

    public RoleService() {
        this.roleDAO = new RoleDAOImp();
    }

}
