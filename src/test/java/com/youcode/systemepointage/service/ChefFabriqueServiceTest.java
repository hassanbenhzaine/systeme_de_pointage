package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.ChefFabrique;
import com.youcode.systemepointage.model.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChefFabriqueServiceTest {
    private static Role randomRole;
    private ChefFabriqueService chefFabriqueService;
    private ChefFabrique chefFabrique;

    @BeforeAll
    static void beforeAll() {
        randomRole = new RoleService().trouverTous().stream().findAny().get();
    }

    @BeforeEach
    void setUp() {
        chefFabriqueService = new ChefFabriqueService();

        chefFabrique = ChefFabrique.builder()
                .entreeFabrique(LocalDate.now())
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
        ChefFabrique addedChefFabrique = chefFabriqueService.ajouter(chefFabrique);
        // then
        assertEquals(chefFabrique, addedChefFabrique);
    }

    @Test
    void modifier() {
        // given
        // when
        ChefFabrique addedChefFabrique = chefFabriqueService.ajouter(chefFabrique);
        chefFabrique.setEntreeFabrique(LocalDate.now());
        ChefFabrique modifiedChefFabrique = chefFabriqueService.modifier(addedChefFabrique);
        // then
        assertEquals(addedChefFabrique, modifiedChefFabrique);
    }

    @Test
    void trouverParId() {
        // given
        // when
        ChefFabrique createdChefFabrique = chefFabriqueService.ajouter(chefFabrique);
        ChefFabrique foundChefFabfriqueById = (ChefFabrique) chefFabriqueService
                .trouverParId(createdChefFabrique.getId());
        // then
        assertEquals(createdChefFabrique, foundChefFabfriqueById);
    }

    @Test
    void trouverTous() {
        // given
        // when
        chefFabriqueService.ajouter(chefFabrique);
        int chefFabriqueCount = chefFabriqueService.trouverTous().size();
        // then
        assertTrue(chefFabriqueCount > 0);
    }
}