package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Utilisateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdresseServiceTest {

    private AdresseService adresseService;
    private Adresse adresse;
    private static Utilisateur utilisateur;

    @BeforeAll
    static void beforeAll() {
        utilisateur = (Utilisateur) new UtilisateurService().trouverTous().stream().findAny().get();
    }

    @BeforeEach
    void setUp() {
        adresseService = new AdresseService();
        adresse = Adresse.builder()
                .adresse1("rue de la paix")
                .adresse2("block 4")
                .codePostal(75000)
                .ville("Paris")
                .pays("France")
                .utilisateur(AdresseServiceTest.utilisateur)
                .build();
    }

    @Test
    void ajouter() {
        // given
        // when
        Adresse addedAdresse = adresseService.ajouter(adresse);
       // then
        assertEquals(adresse,addedAdresse);
    }

    @Test
    void modifier() {
        // given
        // when
        Adresse addedAdresse = adresseService.ajouter(adresse);
        adresse.setAdresse1("rue de la paix hjkjlk2");
        Adresse modifiedAdresse = adresseService.modifier(addedAdresse);
        // then
        assertEquals(addedAdresse,modifiedAdresse);
    }


    @Test
    void supprimer() {
        // given
        // when
        Adresse createdAdresse = adresseService.ajouter(adresse);
        boolean isDeleted = adresseService.supprimer(createdAdresse);
        // then
        assertNull(adresseService.trouverParId(createdAdresse.getId()));
    }

    @Test
    void trouverParId() {
        // given
        // when
        Adresse createdAdresse = adresseService.ajouter(adresse);
        Adresse foundAdresseById = adresseService.trouverParId(createdAdresse.getId());
        // then
        assertEquals(createdAdresse,foundAdresseById);
    }

    @Test
    void trouverTous() {
        // given
        // when
        adresseService.ajouter(adresse);
        int adresseCount = adresseService.trouverTous().size();
        // then
        assertTrue(adresseCount > 0);
    }
}