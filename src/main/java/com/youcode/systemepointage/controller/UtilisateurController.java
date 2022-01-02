package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.PointageService;
import com.youcode.systemepointage.service.UtilisateurService;

import java.util.Collection;

public class UtilisateurController {
    private final UtilisateurService utilisateurService = new UtilisateurService();
    private final PointageService pointageService = new PointageService();

    public Pointage pointerUtilisateur(Utilisateur utilisateur) {
        return pointageService.pointer(utilisateur);
    }

    public Collection<Pointage> trouverTousPointages(Utilisateur utilisateur) {
        return pointageService.parUtilisateur(utilisateur);
    }

    public Utilisateur seConnecter(Utilisateur utilisateur) {
        return utilisateurService.seConnecter(utilisateur);
    }

}
