package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.SecretaireDAOImp;
import com.youcode.systemepointage.model.Secretaire;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.experimental.SuperBuilder;

import java.util.Collection;


public class SecretaireService extends UtilisateurService{
//    private final GenericDAO<Secretaire, Integer> secretaireDAO = new SecretaireDAOImp();
//
//    @Override
//    public Collection<Secretaire> trouverTous() {
//        return secretaireDAO.findAll();
//    }
//
//    @Override
//    public void ajouter(Utilisateur secretaire) {
//        secretaireDAO.create((Secretaire) secretaire);
//    }
//
//    @Override
//    public void modifier(Utilisateur secretaire) {
//        secretaireDAO.update((Secretaire) secretaire);
//    }
//
//    @Override
//    public Utilisateur trouverParId(int id) {
//        return secretaireDAO.find(id)
//                .orElseThrow(() -> new RuntimeException("Secretaire non trouvé"));
//    }
}
