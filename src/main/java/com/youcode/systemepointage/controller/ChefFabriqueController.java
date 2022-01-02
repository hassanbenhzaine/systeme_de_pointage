package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.*;
import com.youcode.systemepointage.service.FormateurService;
import com.youcode.systemepointage.service.PointageService;
import com.youcode.systemepointage.service.SecretaireService;

import java.util.Collection;

public class ChefFabriqueController extends UtilisateurController {
    private final SecretaireService secretaireService = new SecretaireService();
    private final FormateurService formateurService = new FormateurService();
    private final PointageService pointageService = new PointageService();

    public Secretaire ajouterSecretaire(Secretaire secretaire) {
        return secretaireService.ajouter(secretaire);
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
