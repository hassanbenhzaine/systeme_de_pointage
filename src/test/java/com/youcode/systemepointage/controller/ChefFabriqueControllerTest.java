package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Secretaire;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.RoleService;
import com.youcode.systemepointage.service.UtilisateurService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChefFabriqueControllerTest {
    private static Role randomRole;
    private static Utilisateur randomUtilisateur;
    private ChefFabriqueController chefFabriqueController;

    @BeforeAll
    static void beforeAll() {
        randomUtilisateur = new UtilisateurService().trouverTous().stream()
                .findAny().orElse(null);
        randomRole = new RoleService().trouverTous().stream().findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        chefFabriqueController = new ChefFabriqueController();
    }

    @Test
    void ajouterSecretaire() {
        // given
        Secretaire secretaire = Secretaire.builder()
                .statut(true)
                .telephone("0612345678")
                .roleId(randomRole.getId())
                .prenom("prenom")
                .nom("nom")
                .motDePasse("motDePasse")
                .email((new Random().nextInt() + 1) + "@gmail.com")
                .sexe('M')
                .build();
        // when
        Secretaire addedSecretaire = chefFabriqueController.ajouterSecretaire(secretaire);
        // then
        assertEquals(secretaire, addedSecretaire);
    }

    @Test
    @Disabled
        // for yassine to work on it
    void ajouterFormateur() {
    }

    @Test
    void pointagesParUtilisateur() {
        // given
        // when
        Pointage createdPointage = chefFabriqueController.pointerUtilisateur(randomUtilisateur);
        boolean containPointage = chefFabriqueController.pointagesParUtilisateur(randomUtilisateur).stream()
                .allMatch(x -> x.getUtilisateurId().equals(createdPointage.getUtilisateurId()));
        // then
        assertTrue(containPointage);
    }

    @Test
    @Disabled
        // for yassine to work on it
    void pointagesEtudiantParPromotion() {
    }
}