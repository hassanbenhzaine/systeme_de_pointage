package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.ChefFabriqueDAOImpl;
import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.ChefFabrique;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.experimental.SuperBuilder;

import java.util.Collection;


public class ChefFabriqueService extends UtilisateurService{
    private final GenericDAO<ChefFabrique, Integer> chefFabriqueDAO = new ChefFabriqueDAOImpl();

    @Override
    public ChefFabrique ajouter(Utilisateur chefFabrique) {
        return chefFabriqueDAO.create((ChefFabrique) chefFabrique);
    }

    @Override
    public ChefFabrique modifier(Utilisateur chefFabrique) {
        return chefFabriqueDAO.update((ChefFabrique) chefFabrique);
    }

    @Override
    public Collection<ChefFabrique> trouverTous() {
        return chefFabriqueDAO.findAll();
    }

    @Override
    public Utilisateur trouverParId(int id) {
        return chefFabriqueDAO.find(id)
                .orElseThrow(() -> new RuntimeException("ChefFabrique non trouvé"));
    }
}
