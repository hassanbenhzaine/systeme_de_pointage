package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Administrateur;
import com.youcode.systemepointage.model.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdministrateurServiceTest {
    private static Role randomRole;
    private AdministrateurService administrateurService;
    private Administrateur administrateur;

    @BeforeAll
    static void beforeAll() {
        randomRole = new RoleService().trouverTous().stream().findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        administrateurService = new AdministrateurService();

        administrateur = Administrateur.builder()
                .statut(true)
                .telephone("0612345678")
                .role(randomRole)
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
        Administrateur addedAdministrateur = administrateurService.ajouter(administrateur);
        // then
        assertEquals(administrateur, addedAdministrateur);
    }

    @Test
    void modifier() {
        // given
        // when
        Administrateur addedAdministrateur = administrateurService.ajouter(administrateur);
        administrateur.setNom("abc");
        Administrateur modifiedChefFabrique = administrateurService.modifier(addedAdministrateur);
        // then
        assertEquals(addedAdministrateur, modifiedChefFabrique);
    }

    @Test
    void trouverParId() {
        // given
        // when
        Administrateur createdAdministrateur = administrateurService.ajouter(administrateur);
        Administrateur foundAdministrateurById = administrateurService
                .trouverParId(createdAdministrateur.getId());
        // then
        assertEquals(createdAdministrateur, foundAdministrateurById);
    }

    @Test
    void trouverTous() {
        // given
        // when
        administrateurService.ajouter(administrateur);
        int count = administrateurService.trouverTous().size();
        // then
        assertTrue(count > 0);
    }
}