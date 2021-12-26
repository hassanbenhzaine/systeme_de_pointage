package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointageServiceTest {

    private PointageService pointageService;
    private UtilisateurService utilisateurService;
    private Pointage pointage;
    private Utilisateur utilisateur;

    @BeforeEach
    void setUp() {
//        pointageService = new PointageService();
//        utilisateurService = new UtilisateurService();
//        pointage = new Pointage();
//        utilisateur = Utilisateur.builder()
//                .email("cbenhzaine@gmail.com")
//                .nom("Benhzaine")
//                .prenom("Hassan")
//                .motDePasse("123456")
//                .sexe("F")
//                .
    }

    @Test
    void pointer() {
        // given
        utilisateur.setStatut(true);
        // when
        Utilisateur createdUtilisateur = utilisateurService.ajouter(utilisateur);
        Pointage pointage = pointageService.pointer(createdUtilisateur);
        System.out.println(pointage.getUtilisateur());
        System.out.println(utilisateur);
        // then
//        assertEquals(pointage.getUtilisateur(), utilisateur);
    }

    @Test
    void parUtilisateur() {

    }

    @Test
    void etudiantParPromotion() {
    }

    @Test
    void supprimer() {
        // given

        // when
        Utilisateur createdUtilisateur = utilisateurService.ajouter(utilisateur);
        System.out.println(createdUtilisateur);
//        Pointage pointage = pointageService.pointer(createdUtilisateur);
//        pointageService.supprimer(pointage);
        // then
//        assertNull(pointageService.trouverParId(pointage.getId()));
    }

    @Test
    void modifier() {
    }

    @Test
    void trouverParId() {
    }
}