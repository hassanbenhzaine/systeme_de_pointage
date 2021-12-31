package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.*;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PointageServiceTest {

    private PointageService pointageService;
    private UtilisateurService utilisateurService;
    private PromotionService promotionService;
    private Pointage pointage;
    private Utilisateur utilisateur;
    private Promotion promotion;

    @BeforeEach
    void setUp() {
        pointageService = new PointageService();
        utilisateurService = new UtilisateurService();

        utilisateur = (Utilisateur) utilisateurService.trouverTous().stream()
                .findAny().get();
        pointage = Pointage.builder()
                .utilisateur(utilisateur)
                .dateEtHeure(LocalDateTime.of(2020, 12, 30, 9, 59))
                .build();
//        promotion = promotionService.
    }

    @Test
    void pointer() {
        // given
        // when
        Pointage pointage = pointageService.pointer(utilisateur);
        // then
        assertEquals(pointage.getUtilisateur(), utilisateur);
    }

    @Test
    void parUtilisateur() {
        // given
        // when
        Pointage createdPointage = pointageService.pointer(utilisateur);
        boolean containPointage = pointageService.parUtilisateur(utilisateur).stream()
                .allMatch(x -> x.getUtilisateur().equals(createdPointage.getUtilisateur()));
        // then
        assertTrue(containPointage);
    }

    @Test
    @Disabled
    void etudiantParPromotion() {
//        // given
//        // when
//        Pointage createdPointage = pointageService.pointer(utilisateur);
//        boolean containPointage = pointageService.etudiantParPromotion(promotion);
//        // then
//        assertTrue(containPointage);

        // to do after Yassine has worked Pointage
    }

    @Test
    void supprimer() {
        // given
        // when
        Pointage createdAdresse = pointageService.pointer(utilisateur);
        boolean isDeleted = pointageService.supprimer(createdAdresse);
        // then
        assertTrue(isDeleted);
    }

    @Test
    void modifier() {
        // given
        // when
        Pointage addedPointage = pointageService.pointer(utilisateur);
        addedPointage.setDateEtHeure(LocalDateTime.of(2020, 12, 30, 10, 59));
        addedPointage.setUtilisateur(utilisateur);

        Pointage modifiedPointage = pointageService.modifier(addedPointage);
        // then
        assertEquals(addedPointage, modifiedPointage);
    }

    @Test
    void trouverParId() {
        // given
        // when
        Pointage createdPointage = pointageService.pointer(utilisateur);
        Pointage foundRoleById = pointageService.trouverParId(createdPointage.getId());
        // then
        assertEquals(createdPointage.getId(), foundRoleById.getId());
    }
}