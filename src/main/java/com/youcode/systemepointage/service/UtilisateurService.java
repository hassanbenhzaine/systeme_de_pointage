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

    public void seEnregistrer(String nom, String prenom, String email, String motDePasse, String telephone, Adresse adresse, Role role) {
        Utilisateur createdUtilisateur = utilisateurDAO.create(
                new Utilisateur(nom, prenom, email, motDePasse, telephone, role)
        );

        Role foundRole = roleDAO.findByName(role.getNom())
                .orElseThrow(() -> new RuntimeException("Role non trouvé")
                );

        utilisateurDAO.assignRole(createdUtilisateur, foundRole);

        adresse.setUtilisateur(createdUtilisateur);
        adresseDAO.create(adresse);
    }

}
