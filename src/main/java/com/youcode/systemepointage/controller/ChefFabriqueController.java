package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.*;
import com.youcode.systemepointage.service.ChefFabriqueService;
import com.youcode.systemepointage.service.FormateurService;
import com.youcode.systemepointage.service.PointageService;
import com.youcode.systemepointage.service.UtilisateurService;
import lombok.AllArgsConstructor;

import java.util.Collection;

public class ChefFabriqueController {
    private final ChefFabriqueService chefFabriqueService = new ChefFabriqueService();
    private final FormateurService formateurService = new FormateurService();
    private final UtilisateurService utilisateurService = new UtilisateurService();
    private final PointageService pointageService = new PointageService();

    public void ajouterSecretaire(Secretaire secretaire) {
        chefFabriqueService.ajouter(secretaire);
    }

    public void ajouterFormateur(Formateur formateur) {
        formateurService.ajouter(formateur);
    }

    public Collection pointagesParUtilisateur(Utilisateur utilisateur) {
        return pointageService.parUtilisateur(utilisateur);
    }

    public Collection<Pointage> pointagesEtudiantParPromotion(Promotion promotion) {
        return pointageService.etudiantParPromotion(promotion);
    }

    public Collection<ChefFabrique> trouverTousSecretaires(){
        return chefFabriqueService.trouverTous();
    }

    public Collection<Formateur> trouverTousFormateurs(){
        return formateurService.trouverTous();
    }

    public void desactiverSecretaire(Secretaire formateur) {
        utilisateurService.desactiver(formateur);
    }

    public void desactiverFormateur(Formateur formateur) {
        utilisateurService.desactiver(formateur);
    }


    public void modifierSecretaire(Secretaire secretaire) {
        chefFabriqueService.modifier(secretaire);
    }

    public void modifierFormateur(Formateur formateur) {
        formateurService.modifier(formateur);
    }
}
