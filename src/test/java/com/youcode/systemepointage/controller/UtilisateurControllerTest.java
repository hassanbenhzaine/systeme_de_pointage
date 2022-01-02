package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.PointageService;
import com.youcode.systemepointage.service.UtilisateurService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurControllerTest {
    private static Utilisateur randomutilisateur;
    private UtilisateurController utilisateurController;
    private PointageService pointageService;

    @BeforeAll
    static void beforeAll() {
        randomutilisateur = new UtilisateurService().trouverTous().stream()
                .findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        utilisateurController = new UtilisateurController();
        pointageService = new PointageService();
    }

    @Test
    void pointer() {
        // given
        // when
        Pointage pointage = utilisateurController.pointerUtilisateur(randomutilisateur);
        Pointage foundPointage = pointageService.trouverParId(pointage.getId());
        // then
        assertEquals(foundPointage.getUtilisateur(), pointage.getUtilisateur());
    }

    @Test
    void trouverTousPointages() {
        // given
        // when
        Pointage pointage = pointageService.pointer(randomutilisateur);
        int count = utilisateurController.trouverTousPointages(randomutilisateur).size();
        // then
        assertTrue(count > 0);
    }

    @Test
    void seConnecter() {
        // given
        // when
        Utilisateur utilisateur = utilisateurController.seConnecter(randomutilisateur);
        // then
        assertNotNull(utilisateur);
    }

}