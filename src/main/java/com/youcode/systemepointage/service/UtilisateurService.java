package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@Data
public class UtilisateurService {
    private final GenericDAO<Utilisateur, Integer> utilisateurDAO;
    private final RoleService roleService;
    private final AdresseService adresseService;

    public void seConnecter(Utilisateur utilisateur) {
        utilisateurDAO.findAll().parallelStream()
        .filter(u -> u.getEmail() == utilisateur.getEmail()
                && u.getMotDePasse() == utilisateur.getMotDePasse())
        .findFirst().orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public void seEnregistrer(Utilisateur utilisateur, Adresse adresse, Role role) {
        Role foundRole = roleService.trouverParNom(role.getNom());
        utilisateur.setRole(foundRole);
        Utilisateur createdUtilisateur = utilisateurDAO.create(utilisateur);
        adresse.setUtilisateur(createdUtilisateur);
        adresseService.ajouter(adresse);
    }

    public Utilisateur trouverUtilisateurParEmail(Utilisateur utilisateur) {
        return utilisateurDAO.findAll().parallelStream()
                .filter(u -> u.getEmail() == utilisateur.getEmail())
                .findFirst().orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

}
