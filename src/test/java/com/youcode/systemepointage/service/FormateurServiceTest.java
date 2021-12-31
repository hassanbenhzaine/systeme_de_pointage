package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Formateur;
import com.youcode.systemepointage.model.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FormateurServiceTest {
    private static Role randomRole;
    private FormateurService formateurService;
    private Formateur formateur;
    private RoleService roleService;
    private ClasseService classeService;
    private SpecialiteService specialiteService;

    @BeforeAll
    static void beforeAll() {
        randomRole = new RoleService().trouverTous().stream().findAny().get();
    }

    @BeforeEach
    void setUp() {
        formateurService = new FormateurService();
        specialiteService = new SpecialiteService();
        classeService = new ClasseService();

        // en attend de Yassine pour terminer Classe et Specialite
//        Classe randomClasse = ;
//        Specialite specialite = ;
        formateur = Formateur.builder()
                .statut(true)
                .telephone("0612345678")
                .role(randomRole)
                .prenom("prenom")
                .nom("nom")
                .motDePasse("motDePasse")
                .email("cbenhz@gmail.com")
                .sexe('M')
//                .classe()
//                .specialite()
                .build();
    }

    @Test
    @Disabled
        // waiting for yassine to work on Classe and Specialite
    void ajouter() {
        // given
        // when
        Formateur addedChefFabrique = formateurService.ajouter(formateur);
        // then
        assertEquals(formateur, addedChefFabrique);
    }

    @Test
    void modifier() {
        // given
        // when
        Formateur addedChefFabrique = formateurService.ajouter(formateur);
        formateur.setEmail("abc@gmail.com");
        // en attend de yassine pour termier Classe Et specialite
//        formateur.setClasse();
//        formateur.setSpecialite();
        Formateur modifiedChefFabrique = formateurService.modifier(addedChefFabrique);
        // then
        assertEquals(addedChefFabrique, modifiedChefFabrique);
    }

    @Test
    @Disabled
        // waiting for yassine to work on Classe and Specialite
    void trouverParId() {
        // given
        // when
        Formateur createdFormateur = formateurService.ajouter(formateur);
        Formateur foundFormateurById = (Formateur) formateurService
                .trouverParId(createdFormateur.getId());
        // then
        assertEquals(createdFormateur, foundFormateurById);
    }

    @Test
    @Disabled
        // waiting for yassine to work on Classe and Specialite
    void trouverTous() {
        // given
        // when
        formateurService.ajouter(formateur);
        int count = formateurService.trouverTous().size();
        // then
        assertTrue(count > 0);
    }
}