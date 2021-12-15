package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.AdresseDAO;
import com.youcode.systemepointage.dao.AdresseDAOImp;
import com.youcode.systemepointage.dao.UtilisateurDAO;
import com.youcode.systemepointage.dao.UtilisateurDAOImp;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UtilisateurService {
    private final UtilisateurDAO utilisateurDAO;
    private final AdresseDAO adresseDAO;

    public UtilisateurService() {
        this.utilisateurDAO = new UtilisateurDAOImp();
        this.adresseDAO = new AdresseDAOImp();
    }

    public void seConnecter(String email, String motDePasse) {
        utilisateurDAO.findByEmailAndPassword(email, motDePasse)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public void seEnregistrer(String nom, String prenom, String email, String motDePasse, String telephone, Adresse adresse, Role role) {
        Utilisateur createdUtilisateur = utilisateurDAO.create(
                new Utilisateur(nom, prenom, email, motDePasse, telephone, role)
        );

        utilisateurDAO.assignRole(createdUtilisateur, role);
        adresse.setUtilisateur(createdUtilisateur);
        adresseDAO.create(adresse);
    }

}
