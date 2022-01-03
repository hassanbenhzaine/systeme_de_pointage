package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Secretaire;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SecretaireServiceTest {
    private static Role randomRole;
    private SecretaireService secretaireService;
    private Secretaire secretaire;

    @BeforeAll
    static void beforeAll() {
        randomRole = new RoleService().trouverTous().stream().findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        secretaireService = new SecretaireService();

        secretaire = Secretaire.builder()
                .statut(true)
                .telephone("0612345678")
                .roleId(randomRole.getId())
                .prenom("prenom")
                .nom("nom")
                .motDePasse("motDePasse")
                .email("cbenhz@gmail.com")
                .sexe('M')
                .build();
    }

    @Test
    void ajouter() {
        // given
        // when
        Secretaire addedSecretaire = secretaireService.ajouter(secretaire);
        // then
        assertEquals(secretaire, addedSecretaire);
    }

    @Test
    void modifier() {
        // given
        // when
        Secretaire addedSecretaire = secretaireService.ajouter(secretaire);
        secretaire.setNom("abc");
        Secretaire modifiedChefFabrique = secretaireService.modifier(addedSecretaire);
        // then
        assertEquals(addedSecretaire, modifiedChefFabrique);
    }

    @Test
    void trouverParId() {
        // given
        // when
        Secretaire createdSecretaire = secretaireService.ajouter(secretaire);
        Secretaire foundSecretaireById = secretaireService
                .trouverParId(createdSecretaire.getId());
        // then
        assertEquals(createdSecretaire, foundSecretaireById);
    }

    @Test
    void trouverTous() {
        // given
        // when
        secretaireService.ajouter(secretaire);
        int count = secretaireService.trouverTous().size();
        // then
        assertTrue(count > 0);
    }
}