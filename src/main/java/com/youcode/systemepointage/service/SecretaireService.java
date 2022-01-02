package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.SecretaireDAOImp;
import com.youcode.systemepointage.model.Secretaire;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.Collection;

public class SecretaireService extends UtilisateurService {
    private final GenericDAO<Secretaire, Integer> secretaireDAOImp = new SecretaireDAOImp();

    @Override
    public Secretaire ajouter(Utilisateur administrateur) {
        return secretaireDAOImp.create((Secretaire) administrateur);
    }

    @Override
    public Secretaire modifier(Utilisateur administrateur) {
        return secretaireDAOImp.update((Secretaire) administrateur);
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
