package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.*;
import com.youcode.systemepointage.service.ChefFabriqueService;
import com.youcode.systemepointage.service.FormateurService;
import com.youcode.systemepointage.service.PointageService;

import java.util.Collection;

public class ChefFabriqueController extends UtilisateurController{
    private final ChefFabriqueService chefFabriqueService = new ChefFabriqueService();
    private final FormateurService formateurService = new FormateurService();
    private final PointageService pointageService = new PointageService();

    public void ajouterSecretaire(Secretaire secretaire) {
        chefFabriqueService.ajouter(secretaire);
    }

    public void ajouterFormateur(Formateur formateur) {
        formateurService.ajouter(formateur);
    }

    public Collection<Pointage> pointagesParUtilisateur(Utilisateur utilisateur) {
        return pointageService.parUtilisateur(utilisateur);
    }

    public Collection<Pointage> pointagesEtudiantParPromotion(Promotion promotion) {
        return pointageService.etudiantParPromotion(promotion);
    }
}
