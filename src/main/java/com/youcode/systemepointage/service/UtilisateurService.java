package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@AllArgsConstructor
@Data
public class UtilisateurService {
    private final GenericDAO<Utilisateur, Integer> utilisateurDAO;
    private final RoleService roleService;
    private final AdresseService adresseService;

    public boolean seConnecter(Utilisateur utilisateur) {
       return utilisateurDAO.findAll().parallelStream()
        .filter(u -> u.getEmail().equals(utilisateur.getEmail())
                && u.getMotDePasse().equals(utilisateur.getMotDePasse()))
               .anyMatch( x -> true);
    }

    public void seEnregistrer(Utilisateur utilisateur, Adresse adresse, Role role) {
        Role foundRole = roleService.trouverParNom(role.getNom());
        utilisateur.setRole(foundRole);
        Utilisateur createdUtilisateur = utilisateurDAO.create(utilisateur);
        adresse.setUtilisateur(createdUtilisateur);
        adresseService.ajouter(adresse);
    }

    public Utilisateur trouverParEmail(Utilisateur utilisateur) {
        return utilisateurDAO.findAll().parallelStream()
                .filter(u -> u.getEmail().equals(utilisateur.getEmail()))
                .findFirst().orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public void desactiver(Utilisateur utilisateur) {
        utilisateur.setStatut(false);
        utilisateurDAO.update(utilisateur);
    }

    public Collection trouverTous() {
        return utilisateurDAO.findAll();
    }


    public void ajouter(Utilisateur utilisateur) {
        utilisateurDAO.create(utilisateur);
    }

    public void modifier(Utilisateur utilisateur) {
        utilisateurDAO.update(utilisateur);
    }

    public void supprimer(Utilisateur utilisateur) {
        utilisateurDAO.delete(utilisateur.getId());
    }
}
