package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.RoleDAOImp;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Roles;

import java.util.Collection;


public class RoleService {
    private final GenericDAO<Role, Integer> roleDAO = new RoleDAOImp();

    public Role ajouter(Role role) {
        return roleDAO.create(role);
    }

    public Role trouverParNom(Roles role) {
        return roleDAO.findAll()
                .stream().parallel()
                .filter(r -> r.getNom().equals(role))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Role introuvable"));
    }

    public Role trouverParId(int id) {
        return roleDAO.find(id).orElseThrow(() -> new RuntimeException("Role introuvable"));
    }

    public Role modifier(Role role) {
        return roleDAO.update(role);
    }

    public boolean supprimer(int id) {
        return roleDAO.delete(id);
    }

    public Collection<Role> trouverTous() {
        return roleDAO.findAll();
    }

}
