package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Promotion;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.PointageService;
import com.youcode.systemepointage.service.UtilisateurService;

import java.util.Collection;

public class AdministrateurController extends UtilisateurController {
    private final UtilisateurService utilisateurService = new UtilisateurService();
    private final PointageService pointageService = new PointageService();

    public void desactiverUtilisateur(Utilisateur utilisateur) {
        utilisateurService.desactiver(utilisateur);
    }

    public void changerMotDePasseUtilisateur(Utilisateur utilisateur) {
        utilisateurService.modifier(utilisateur);
    }

    public Collection<Pointage> pointagesParUtilisateur(Utilisateur utilisateur) {
        return pointageService.parUtilisateur(utilisateur);
    }

    public Collection<Pointage> pointagesEtudiantParPromotion(Promotion promotion) {
        return pointageService.etudiantParPromotion(promotion);
    }

    public Pointage pointerUtilisateur(Utilisateur utilisateur) {
        return pointageService.pointer(utilisateur);
    }

    public Pointage modifierPointage(Pointage pointage) {
        return pointageService.modifier(pointage);
    }

    public Collection<Pointage> trouverTousPointages() {
        return pointageService.trouverTous();
    }

    public void supprmierPointage(Pointage pointage) {
        pointageService.supprimer(pointage);
    }
}
