package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Promotion;
import com.youcode.systemepointage.model.Utilisateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PointageServiceTest {

    private PointageService pointageService;
    private UtilisateurService utilisateurService;
    private PromotionService promotionService;
    private Pointage pointage;
    private static Utilisateur randomutilisateur;
    private Promotion promotion;

    @BeforeAll
    static void beforeAll() {
        randomutilisateur = (Utilisateur) new UtilisateurService().trouverTous().stream()
                .findAny().get();
    }

    @BeforeEach
    void setUp() {
        pointageService = new PointageService();
        utilisateurService = new UtilisateurService();

        pointage = Pointage.builder()
                .utilisateur(randomutilisateur)
                .dateEtHeure(LocalDateTime.now())
                .build();
    }

    @Test
    void pointer() {
        // given
        // when
        Pointage pointage = pointageService.pointer(randomutilisateur);
        // then
        assertEquals(pointage.getUtilisateur(), randomutilisateur);
    }

    @Test
    void parUtilisateur() {
        // given
        // when
        Pointage createdPointage = pointageService.pointer(randomutilisateur);
        boolean containPointage = pointageService.parUtilisateur(randomutilisateur).stream()
                .allMatch(x -> x.getUtilisateur().equals(createdPointage.getUtilisateur()));
        // then
        assertTrue(containPointage);
    }

    @Test
    @Disabled
    void etudiantParPromotion() {
//        // given
//        // when
//        Pointage createdPointage = pointageService.pointer(randomutilisateur);
//        boolean containPointage = pointageService.etudiantParPromotion(promotion);
//        // then
//        assertTrue(containPointage);

        // to do after Yassine has worked Pointage
    }

    @Test
    void supprimer() {
        // given
        // when
        Pointage createdAdresse = pointageService.pointer(randomutilisateur);
        pointageService.supprimer(createdAdresse);
        // then
        assertNull(pointageService.trouverParId(createdAdresse.getId()));
    }

    @Test
    void modifier() {
        // given
        // when
        Pointage addedPointage = pointageService.pointer(randomutilisateur);
        addedPointage.setDateEtHeure(LocalDateTime.of(2020, 12, 30, 10, 59));
        addedPointage.setUtilisateur(randomutilisateur);

        Pointage modifiedPointage = pointageService.modifier(addedPointage);
        // then
        assertEquals(addedPointage, modifiedPointage);
    }

    @Test
    void trouverParId() {
        // given
        // when
        Pointage createdPointage = pointageService.pointer(randomutilisateur);
        Pointage foundRoleById = pointageService.trouverParId(createdPointage.getId());
        // then
        assertEquals(createdPointage.getId(), foundRoleById.getId());
    }
}