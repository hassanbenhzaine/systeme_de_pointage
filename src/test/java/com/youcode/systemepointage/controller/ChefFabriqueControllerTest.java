package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Secretaire;
import com.youcode.systemepointage.service.RoleService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;

class ChefFabriqueControllerTest {
    private static Role randomRole;
    private ChefFabriqueController chefFabriqueController;

    @BeforeAll
    static void beforeAll() {
        randomRole = new RoleService().trouverTous().stream().findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        chefFabriqueController = new ChefFabriqueController();
    }

    @Test
    void ajouterSecretaire() {
        // given
        // when
        Secretaire secretaire = Secretaire.builder()
                .statut(true)
                .telephone("0612345678")
                .role(randomRole)
                .prenom("prenom")
                .nom("nom")
                .motDePasse("motDePasse")
                .email((new Random().nextInt() + 1) + "@gmail.com")
                .sexe('M')
                .build();
        chefFabriqueController.ajouterSecretaire(secretaire);
        // then
    }

    @Test
    @Disabled
        // for yassine to work on it
    void ajouterFormateur() {
    }

    @Test
    void pointagesParUtilisateur() {
    }

    @Test
    void pointagesEtudiantParPromotion() {
    }
}