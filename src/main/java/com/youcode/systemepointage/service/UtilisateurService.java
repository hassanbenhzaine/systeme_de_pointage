package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.UtilisateurDAOImp;
import com.youcode.systemepointage.dao.UtilisateurDAO;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.Optional;

public class UtilisateurService {

    public void seConnecter(String email, String motDePasse) {
        UtilisateurDAO utilisateurDAO = new UtilisateurDAOImp();

        Optional<Utilisateur> utilisateur = utilisateurDAO.findByEmailAndPassword(email, motDePasse);
        utilisateur.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }



}
