package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurServiceTest {
    private static Role randomRole;
    private UtilisateurService utilisateurService;
    private Utilisateur utilisateur;

    @BeforeAll
    static void beforeAll() {
        randomRole = new RoleService().trouverTous().stream().findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        utilisateurService = new UtilisateurService();

        utilisateur = Utilisateur.builder()
                .statut(true)
                .telephone("0612345678")
                .role(randomRole)
                .prenom("prenom")
                .nom("nom")
                .motDePasse("motDePasse")
                .email((new Random().nextInt() + 1) + "@gmail.com")
                .sexe('M')
                .build();
    }

    @Test
    void seConnecter() {
        // given
        // when
        Utilisateur addedUtillisateur = utilisateurService.ajouter(utilisateur);
        Utilisateur foundUtilisateur = utilisateurService.seConnecter(addedUtillisateur);
        // then
        assertEquals(foundUtilisateur, addedUtillisateur);
    }

    @Test
    void seEnregistrer() {
        // given
        // when
        Utilisateur addedUtillisateur = utilisateurService.seEnregistrer(utilisateur);
        // then
        assertEquals(utilisateur, addedUtillisateur);
    }

    @Test
    void trouverParEmail() {
        // given
        // when
        Utilisateur addedUtillisateur = utilisateurService.ajouter(utilisateur);
        Utilisateur foundUtilisateur = utilisateurService.trouverParEmail(addedUtillisateur.getEmail());
        // then
        assertEquals(addedUtillisateur, foundUtilisateur);
    }

    @Test
    void desactiver() {
        // given
        // when
        Utilisateur addedUtillisateur = utilisateurService.ajouter(utilisateur);
        utilisateurService.desactiver(addedUtillisateur);
        Utilisateur disabledUtilisateur = utilisateurService.trouverParId(addedUtillisateur.getId());
        // then
        assertFalse(disabledUtilisateur.getStatut());
    }

    @Test
    void supprimer() {
        // given
        // when
        Utilisateur addedUtillisateur = utilisateurService.ajouter(utilisateur);
        utilisateurService.supprimer(addedUtillisateur);
        // then
        assertNull(utilisateurService.trouverParId(addedUtillisateur.getId()));
    }

    @Test
    void ajouter() {
        // given
        // when
        Utilisateur addedUtillisateur = utilisateurService.ajouter(utilisateur);
        // then
        assertEquals(utilisateur, addedUtillisateur);
    }

    @Test
    void modifier() {
        // given
        // when
        Utilisateur addedUtillisateur = utilisateurService.ajouter(utilisateur);
        utilisateur.setMotDePasse("abcdef");
        Utilisateur modifiedUtilisateur = utilisateurService.modifier(addedUtillisateur);
        // then
        assertEquals(addedUtillisateur, modifiedUtilisateur);
    }


    @Test
    void trouverTous() {
        // given
        // when
        utilisateurService.ajouter(utilisateur);
        int count = utilisateurService.trouverTous().size();
        // then
        assertTrue(count > 0);
    }
}