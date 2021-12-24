package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleServiceTest {

    private RoleService roleService;
    private Role role;

    @BeforeEach
    void setUp() {
        role = new Role();
        roleService = new RoleService();
    }

    @Test
    void ajouter() {
        // given
        role.setNom(Roles.CHEFFABRIQUE);
        // when
        Role addedRole = roleService.ajouter(role);
        // then
        assertEquals(role.getNom(), addedRole.getNom());
    }

    @Test
    void trouverParNom() {
        // given
        role.setNom(Roles.ADMINISTATEUR);
        // when
        Role createdRole = roleService.ajouter(role);
        // then
        assertEquals(role.getNom(), createdRole.getNom());
    }

    @Test
    void trouverParId() {
        // given
        role.setNom(Roles.ETUDIANT);
        // when
        Role createdRole = roleService.ajouter(role);
        Role foundRoleById = roleService.trouverParId(createdRole.getId());
        // then
        assertEquals(role.getId(), foundRoleById.getId());
    }

    @Test
    void modifier() {
        // given
        role.setNom(Roles.FORMATTEUR);
        // when
        Role createdRole = roleService.ajouter(role);
        Role modifiedCreatedRole = Role.builder().nom(Roles.SECRETAIRE).id(createdRole.getId()).build();
        Role modifiedRole = roleService.modifier(modifiedCreatedRole);
        // then
        assertNotEquals(createdRole.getNom(), modifiedRole.getNom());
    }

    @Test
    void supprimer() {
        // given
        role.setNom(Roles.ETUDIANT);
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