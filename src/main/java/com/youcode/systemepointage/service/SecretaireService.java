package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Secretaire;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class SecretaireService extends UtilisateurService{
    private final GenericDAO<Secretaire, Integer> secretaireDAO;


//    @Override
//    public Collection<Utilisateur> trouverTous() {
//        // return collection<child> to collection<parent>
//        return secretaireDAO.findAll();
//    }

    @Override
    public void ajouter(Utilisateur secretaire) {
        secretaireDAO.create((Secretaire) secretaire);
    }

    @Override
    public void modifier(Utilisateur secretaire) {
        secretaireDAO.update((Secretaire) secretaire);
    }
}
