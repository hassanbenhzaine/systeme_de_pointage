package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.ChefFabriqueDAOImpl;
import com.youcode.systemepointage.dao.EvenementDAOImp;
import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.ChefFabrique;
import com.youcode.systemepointage.model.Evenement;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.Collection;


public class ChefFabriqueService extends UtilisateurService{
    private final GenericDAO<ChefFabrique, Integer> chefFabriqueDAO = new ChefFabriqueDAOImpl();
    private final GenericDAO<Evenement, Integer> evenementDAO = new EvenementDAOImp();

    @Override
    public ChefFabrique ajouter(Utilisateur chefFabrique) {
        return chefFabriqueDAO.create((ChefFabrique) chefFabrique);
    }

    public Evenement ajouter(Evenement evenement){
        return evenementDAO.create(evenement);
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
    public ChefFabrique trouverParId(int id) {
        return chefFabriqueDAO.find(id).orElse(null);
    }
}
