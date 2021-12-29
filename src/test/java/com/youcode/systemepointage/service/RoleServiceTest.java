package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RoleServiceTest {

    private RoleService roleService;
    private Role role;

    @BeforeEach
    void setUp() {
        role = new Role();
        role.setNom(Roles.values()[new Random().nextInt(Roles.values().length)]);
        roleService = new RoleService();
    }

    @Test
    void ajouter() {
        // given

        // when
        Role addedRole = roleService.ajouter(role);
        // then
        assertEquals(role.getNom(), addedRole.getNom());
    }

    @Test
    void trouverParNom() {
        // given

        // when
        Role createdRole = roleService.ajouter(role);
        // then
        assertEquals(role.getNom(), createdRole.getNom());
    }

    @Test
    void trouverParId() {
        // given

        // when
        Role createdRole = roleService.ajouter(role);
        Role foundRoleById = roleService.trouverParId(createdRole.getId());
        // then
        assertEquals(role.getId(), foundRoleById.getId());
    }

    @Test
    void modifier() {
        // given

        // when
        Role createdRole = roleService.ajouter(role);
        Role modifiedRole = roleService.modifier(
                Role.builder().nom(Roles.FORMATTEUR).id(createdRole.getId()).build()
        );
        // then
        assertNotEquals(createdRole.getNom(), modifiedRole.getNom());
    }

    @Test
    void supprimer() {
        // given
        // when
        Role createdRole = roleService.ajouter(role);
        Boolean isDeleted = roleService.supprimer(createdRole.getId());
        // then
        assertEquals(true, isDeleted);
    }

    @Test
    void trouverTous() {
        // given
        role.setNom(Roles.ADMINISTATEUR);
        // when
        Role createdRole = roleService.ajouter(role);
        // then
        assertTrue(roleService.trouverTous().size() >= 1);
    }
}