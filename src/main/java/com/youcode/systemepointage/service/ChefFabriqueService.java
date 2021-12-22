package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.ChefFabrique;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.experimental.SuperBuilder;

import java.util.Collection;


@SuperBuilder
public class ChefFabriqueService extends UtilisateurService{
    private final GenericDAO<ChefFabrique, Integer> chefFabriqueDAO;

    @Override
    public void ajouter(Utilisateur chefFabrique) {
        chefFabriqueDAO.create((ChefFabrique) chefFabrique);
    }

    @Override
    public void modifier(Utilisateur utilisateur) {
        chefFabriqueDAO.update((ChefFabrique) utilisateur);
    }

    @Override
    public Collection<ChefFabrique> trouverTous() {
        return chefFabriqueDAO.findAll();
    }
}
