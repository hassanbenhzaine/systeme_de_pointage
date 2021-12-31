package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Roles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RoleServiceTest {

    private RoleService roleService;
    private Role role;

    @BeforeEach
    void setUp() {
        roleService = new RoleService();
        role = new Role();

        Roles randomRoleEnum = Roles.values()[new Random().nextInt(Roles.values().length)];
        role.setNom(randomRoleEnum);
    }

    @Test
    void ajouter() {
        // given
        // when
        Role addedRole = roleService.ajouter(role);
        // then
        assertEquals(role, addedRole);
    }

    @Test
    void trouverParNom() {
        // given
        // when
        Role createdRole = roleService.ajouter(role);
        Role foundRoleByNom = roleService.trouverParNom(createdRole.getNom());
        // then
        assertEquals(createdRole.getNom(), foundRoleByNom.getNom());
    }

    @Test
    void trouverParId() {
        // given
        // when
        Role createdRole = roleService.ajouter(role);
        Role foundRoleById = roleService.trouverParId(createdRole.getId());
        // then
        assertEquals(createdRole.getId(), foundRoleById.getId());
    }

    @Test
    void modifier() {
        // given
        // when
        Role createdRole = roleService.ajouter(role);
        createdRole.setNom(Roles.values()[new Random().nextInt(Roles.values().length)]);
        Role modifiedRole = roleService.modifier(createdRole);
        // then
        assertEquals(createdRole, modifiedRole);
    }

    @Test
    void supprimer() {
        // given
        // when
        Role createdRole = roleService.ajouter(role);
        boolean isDeleted = roleService.supprimer(createdRole);
        // then
        assertTrue(isDeleted);
    }

    @Test
    void trouverTous() {
        // given
        // when
        roleService.ajouter(role);
        int roleCount = roleService.trouverTous().size();
        // then
        assertTrue(roleCount > 0);
    }
}