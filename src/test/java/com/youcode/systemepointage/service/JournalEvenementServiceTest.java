//package com.youcode.systemepointage.service;
//
//import com.youcode.systemepointage.model.Evenement;
//import com.youcode.systemepointage.model.JournalEvenement;
//import com.youcode.systemepointage.model.Utilisateur;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class JournalEvenementServiceTest {
//    private EvenementService evenementService;
//    private JournalEvenementService journalEvenementService;
//    private static Evenement randomevenement;
//    private JournalEvenement journalEvenement;
//    private static Utilisateur randomUtilisateur;
//
//    @BeforeAll
//    static void beforeAll() {
//        randomUtilisateur = new UtilisateurService().trouverTous().stream().findAny().orElse(null);
//        randomevenement = new EvenementService().findAll().stream().findAny().orElse(null);
//    }
//
//    @BeforeEach
//    void setUp() {
//        journalEvenementService = new JournalEvenementService();
//
//        journalEvenement = JournalEvenement.builder()
//                .id(1)
//                .modification(LocalDateTime.of(LocalDate.of(2020, 12, 20),
//                        LocalTime.of(12,46, 20)))
//                .ajoute(LocalDateTime.of(LocalDate.of(2020, 12, 20),
//                        LocalTime.of(12,46, 20)))
//                .suppression(LocalDateTime.of(LocalDate.of(2020, 12, 20),
//                        LocalTime.of(12,46, 20)))
//                .evenement(randomevenement)
//                .utilisateur(randomUtilisateur)
//                .build();
//    }
//
//    @Test
//    void ajouter() {
//        JournalEvenement addournalEvenement = journalEvenementService.ajouter(journalEvenement);
//        assertEquals(journalEvenement, addournalEvenement);
//    }
//
//    @Test
//    void supprimer() {
//
//    }
//
//    @Test
//    void modifier() {
//        JournalEvenement editournalEvenement = journalEvenementService.modifier(journalEvenement);
//        assertEquals(journalEvenement, editournalEvenement);
//    }
//
//    @Test
//    void trouverParId() {
//        JournalEvenement editournalEvenement = journalEvenementService.modifier(journalEvenement);
//        JournalEvenement fjournalEvenement =journalEvenementService.trouverParId(editournalEvenement.getId());
//        assertEquals(editournalEvenement.getId(), fjournalEvenement.getId());
//    }
//
//    @Test
//    void trouverTout() {
//    }
//}