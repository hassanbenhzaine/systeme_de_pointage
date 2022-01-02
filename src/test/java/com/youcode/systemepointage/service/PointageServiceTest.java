package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PointageServiceTest {

    private PointageService pointageService;
    private static Utilisateur randomUtilisateur;

    @BeforeAll
    static void beforeAll() {
        randomUtilisateur = new UtilisateurService().trouverTous().stream().findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        pointageService = new PointageService();
    }

    @Test
    void pointer() {
        // given
        // when
        Pointage pointage = pointageService.pointer(randomUtilisateur);
        // then
        assertEquals(pointage.getUtilisateur(), randomUtilisateur);
    }

    @Test
    void parUtilisateur() {
        // given
        // when
        Pointage createdPointage = pointageService.pointer(randomUtilisateur);
        boolean containPointage = pointageService.parUtilisateur(randomUtilisateur).stream()
                .allMatch(x -> x.getUtilisateur().equals(createdPointage.getUtilisateur()));
        // then
        assertTrue(containPointage);
    }

    @Test
    @Disabled
    void etudiantParPromotion() {
//        // given
//        // when
//        Pointage createdPointage = pointageService.pointer(randomUtilisateur);
//        boolean containPointage = pointageService.etudiantParPromotion(promotion);
//        // then
//        assertTrue(containPointage);

        // to do after Yassine has worked Pointage
    }

    @Test
    void supprimer() {
        // given
        // when
        Pointage createdAdresse = pointageService.pointer(randomUtilisateur);
        pointageService.supprimer(createdAdresse);
        // then
        assertNull(pointageService.trouverParId(createdAdresse.getId()));
    }

    @Test
    void modifier() {
        // given
        // when
        Pointage addedPointage = pointageService.pointer(randomUtilisateur);

        addedPointage.setDateEtHeure(LocalDateTime.now());
        addedPointage.setUtilisateur(randomUtilisateur);

        Pointage modifiedPointage = pointageService.modifier(addedPointage);
        // then
        assertEquals(addedPointage, modifiedPointage);
    }

    @Test
    void trouverParId() {
        // given
        // when
        Pointage createdPointage = pointageService.pointer(randomUtilisateur);
        Pointage foundRoleById = pointageService.trouverParId(createdPointage.getId());
        // then
        assertEquals(createdPointage.getId(), foundRoleById.getId());
    }
}