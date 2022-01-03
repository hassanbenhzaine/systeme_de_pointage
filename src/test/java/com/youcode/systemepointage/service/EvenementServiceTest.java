package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Evenement;
import com.youcode.systemepointage.model.JournalEvenement;
import com.youcode.systemepointage.model.Utilisateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EvenementServiceTest {
    private EvenementService evenementService;
    private JournalEvenementService journalEvenementService;
    private Evenement evenement;
    private JournalEvenement journalEvenement;
    private static Utilisateur randomUtilisateur;

    @BeforeAll
    static void beforeAll() {
        randomUtilisateur = new UtilisateurService().trouverTous().stream().findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        evenementService = new EvenementService();
        journalEvenementService = new JournalEvenementService();

        evenement = Evenement.builder()
                .id(1)
                .fin(LocalDateTime.of(LocalDate.of(2020, 12, 20),
                        LocalTime.of(12,46, 20)))
                .debut(LocalDateTime.of(LocalDate.of(2020, 12, 20),
                        LocalTime.of(12,46, 20)))
                .nom("yahya41")
                .description("description evenement 2")
                .proposer(false)
                .build();
    }

    @Test
    void create() {
//        Evenement addEvenement = evenementService.create(evenement , randomUtilisateur);
//        assertEquals(evenement, addEvenement);
    }

    @Test
    void update() {
        Evenement editEvenement = evenementService.update(evenement, randomUtilisateur);
        assertEquals(evenement, editEvenement);
    }

    @Test
    void find() {
        Evenement updateEvenement = evenementService.update(evenement , randomUtilisateur);
        Evenement fevenement = evenementService.find(updateEvenement.getId());

        assertEquals(updateEvenement.getId(), fevenement.getId());
    }

    @Test
    void findAll() {
        int count = evenementService.findAll().size();
        // then
        assertTrue(count > 0);
    }

    @Test
    void delete() {
        Evenement updateEvenement = evenementService.update(evenement , randomUtilisateur);
        evenementService.delete(updateEvenement.getId());
        assertNull(evenementService.find(updateEvenement.getId()));
    }
}