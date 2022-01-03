package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Evenement;
import com.youcode.systemepointage.model.Specialite;
import com.youcode.systemepointage.model.Utilisateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class SpecialiteServiceTest {
    private Specialite specialite;
    private SpecialiteService specialiteService;
    private static Utilisateur randomUtilisateur;

    @BeforeAll
    static void beforeAll() {
        randomUtilisateur = new UtilisateurService().trouverTous().stream().findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        specialiteService = new SpecialiteService();

        specialite = Specialite.builder()
                .nom("test")
                .id(1)
                .build();
        //        .id(1)
//                .fin(LocalDateTime.of(LocalDate.of(2020, 12, 20),
//                        LocalTime.of(12,46, 20)))
//                .debut(LocalDateTime.of(LocalDate.of(2020, 12, 20),
//                        LocalTime.of(12,46, 20)))
//                .nom("yahya41")
//                .description("description evenement 2")
//                .proposer(false)
//                .build();

    }

    @Test
    void create() {
        Specialite addSpecialite = specialiteService.create(specialite);
        assertEquals(specialite, addSpecialite);
    }

    @Test
    void update() {
        Specialite updateSpecialite = specialiteService.update(specialite);
        assertEquals(specialite, updateSpecialite);
    }

    @Test
    void find() {
        Specialite updateSpecialite = specialiteService.update(specialite);
         Specialite fspecialite = specialiteService.find(updateSpecialite.getId());
         assertEquals(updateSpecialite.getId(), fspecialite.getId());
    }

    @Test
    void findAll() {
        int count = specialiteService.findAll().size();
        // then
        assertTrue(count > 0);
    }

    @Test
    void delete() {
        Specialite updateSpecialite = specialiteService.update(specialite);
        specialiteService.delete(updateSpecialite.getId());
        assertNull(specialiteService.find(updateSpecialite.getId()));
    }
}