package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.*;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UtilisateurService {
    private final UtilisateurDAO utilisateurDAO;
    private final AdresseDAO adresseDAO;
    private final RoleDAO roleDAO;

    public UtilisateurService() {
        this.utilisateurDAO = new UtilisateurDAOImp();
        this.adresseDAO = new AdresseDAOImp();
        this.roleDAO = new RoleDAOImp();
    }

    public void seConnecter(String email, String motDePasse) {
        utilisateurDAO.findByEmailAndPassword(email, motDePasse)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public void seEnregistrer(Utilisateur utilisateur, Adresse adresse, Role role) {
        utilisateur.setRole(role);
        Utilisateur createdUtilisateur = utilisateurDAO.create(utilisateur);

        Role foundRole = roleDAO
                .findByName(role.getNom())
                .orElseThrow(() -> new RuntimeException("Role non trouvé")
        );

        createdUtilisateur.setRole(foundRole);
        utilisateurDAO.update(createdUtilisateur);

        adresse.setUtilisateur(createdUtilisateur);
        adresseDAO.create(adresse);
    }

    public Utilisateur trouverUtilisateur(String email) {
        return utilisateurDAO.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

}
