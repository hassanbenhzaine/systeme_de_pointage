package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.SecretaireDAOImp;
import com.youcode.systemepointage.model.Secretaire;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.Collection;

public class SecretaireService extends UtilisateurService {
    private final GenericDAO<Secretaire, Integer> secretaireDAOImp = new SecretaireDAOImp();

    @Override
    public Secretaire ajouter(Utilisateur secretaire) {
        return secretaireDAOImp.create((Secretaire) secretaire);
    }

    @Override
    public Secretaire modifier(Utilisateur secretaire) {
        return secretaireDAOImp.update((Secretaire) secretaire);
    }

    @Override
    public Collection<Secretaire> trouverTous() {
        return secretaireDAOImp.findAll();
    }

    @Override
    public Secretaire trouverParId(int id) {
        return secretaireDAOImp.find(id).orElse(null);
    }

}
