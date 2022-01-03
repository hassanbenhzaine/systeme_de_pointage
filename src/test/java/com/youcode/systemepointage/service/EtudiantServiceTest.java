package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Etudiant;
import com.youcode.systemepointage.model.Formateur;
import com.youcode.systemepointage.model.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EtudiantServiceTest {
    private static Role randomRole;
    private static Formateur randomFormateur;
    //    private static Promotion randomPromotion;
    private EtudiantService etudiantService;
    private Etudiant etudiant;

    @BeforeAll
    static void beforeAll() {
        randomRole = new RoleService().trouverTous().stream().findAny().orElse(null);
        randomFormateur = new FormateurService().trouverTous().stream().findAny().orElse(null);
//        randomPromotion = new PromotionService().trouverTous().stream().findAny().orElse(null);
    }


    // waiting for yassine to finish classe and specialite
    @BeforeEach
    void setUp() {
        etudiantService = new EtudiantService();

        etudiant = Etudiant.builder()
                .statut(true)
                .telephone("0612345678")
                .role(randomRole)
                .prenom("prenom")
                .nom("nom")
                .motDePasse("motDePasse")
                .email("cbenhz@gmail.com")
                .sexe('M')
                .formateur(randomFormateur)
//                .classe(null)
//                .specialite(null)
                .build();
    }

    @Test
    void ajouter() {
        // given
        // when
        Etudiant addedEtudiant = etudiantService.ajouter(etudiant);
        // then
        assertEquals(etudiant, addedEtudiant);
    }

    @Test
    void modifier() {
        // given
        // when
        Etudiant addedEtudiant = etudiantService.ajouter(etudiant);
        etudiant.setNom("abc");
        Etudiant modifiedEtudiant = etudiantService.modifier(addedEtudiant);
        // then
        assertEquals(addedEtudiant, modifiedEtudiant);
    }

    // waiting for yassine to finish classe and specialite
    @Test
    @Disabled
    void trouverParId() {
        // given
        // when
        Etudiant createdEtudiant = etudiantService.ajouter(etudiant);
        Etudiant foundEtudiantById = etudiantService
                .trouverParId(createdEtudiant.getId());
        // then
        assertEquals(createdEtudiant, foundEtudiantById);
    }

    // waiting for yassine to finish classe and specialite
    @Test
    @Disabled
    void trouverTous() {
        // given
        // when
        etudiantService.ajouter(etudiant);
        int count = etudiantService.trouverTous().size();
        // then
        assertTrue(count > 0);
    }

    // waiting for yassine to finish classe and specialite
    @Test
    @Disabled
    void effectifParPromotion() {
        // given
        // when
        etudiantService.ajouter(etudiant);
//        int count = etudiantService.effectifParPromotion();
        // then
//        assertTrue(count > 0);
    }

    @Test
    @Disabled
        // waiting for yassine to finish classe and specialite
    void nbrGarconsParPromotion() {
    }

    @Test
    @Disabled
        // waiting for yassine to finish classe and specialite
    void nbrFillesParPromotion() {
    }

    @Test
    @Disabled
        // waiting for yassine to finish classe and specialite
    void effectifParClasse() {
    }
}