package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.ChefFabrique;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.ChefFabriqueService;
import com.youcode.systemepointage.service.UtilisateurService;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class AdministrateurController {
    private final ChefFabriqueService chefFabriqueService;
    private final UtilisateurService utilisateurService;

    public void ajouterChefFabrique(ChefFabrique chefFabrique) {
        chefFabriqueService.ajouter(chefFabrique);
    }

    public void modifierChefFabrique(ChefFabrique chefFabrique) {
        chefFabriqueService.modifier(chefFabrique);
    }

    public Collection<ChefFabrique> trouverTousChefFabrique() {
        return chefFabriqueService.trouverTous();
    }

    public void desactiverUtilisateur(Utilisateur utilisateur) {
        utilisateurService.desactiver(utilisateur);
    }
}
