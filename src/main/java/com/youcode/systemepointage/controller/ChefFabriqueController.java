package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.*;
import com.youcode.systemepointage.service.*;

import java.util.Collection;

public class ChefFabriqueController extends UtilisateurController {
    private final SecretaireService secretaireService = new SecretaireService();
    private final FormateurService formateurService = new FormateurService();
    private final PointageService pointageService = new PointageService();
    private final EvenementService evenementService = new EvenementService();

    public Secretaire ajouterSecretaire(Secretaire secretaire) {
        return secretaireService.ajouter(secretaire);
    }

    public Evenement ajouterEvenement(Evenement evenement, Utilisateur utilisateur){
        return evenementService.create(evenement , utilisateur);
    }

    public Evenement editEvenement(Evenement evenement, Utilisateur utilisateur){
        return evenementService.update(evenement, utilisateur);
    }

    public Collection<Evenement> trouverTousEvenement(){
        return evenementService.findAll();
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
