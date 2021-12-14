package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.UtilisateurDAOImp;
import com.youcode.systemepointage.dao.UtilisateurDAO;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UtilisateurService {
    private UtilisateurDAO utilisateurDAO;

    public void seConnecter(String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurDAO.findByEmailAndPassword(email, motDePasse)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

    }



}
