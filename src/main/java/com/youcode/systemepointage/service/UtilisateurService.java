package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.UtilisateurDAOImp;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.Collection;


public class UtilisateurService {
    private final GenericDAO<Utilisateur, Integer> utilisateurDAO = new UtilisateurDAOImp();

    public Utilisateur seConnecter(Utilisateur utilisateur) {
        return utilisateurDAO.findAll().stream().parallel()
                .filter(u -> u.getEmail().equals(utilisateur.getEmail())
                        && u.getMotDePasse().equals(utilisateur.getMotDePasse()))
                .findAny().orElse(null);
    }

    public Utilisateur seEnregistrer(Utilisateur utilisateur) {
        return utilisateurDAO.create(utilisateur);
    }

    public Utilisateur trouverParEmail(String email) {
        return utilisateurDAO.findAll().stream().parallel()
                .filter(u -> u.getEmail().equals(email))
                .findFirst().orElse(null);
    }

    public boolean desactiver(Utilisateur utilisateur) {
        utilisateur.setStatut(false);
        return utilisateurDAO.update(utilisateur) != null;
    }

    public Collection trouverTous() {
        return utilisateurDAO.findAll();
    }


    public Utilisateur ajouter(Utilisateur utilisateur) {
        return utilisateurDAO.create(utilisateur);
    }

    public Utilisateur modifier(Utilisateur utilisateur) {
        return utilisateurDAO.update(utilisateur);
    }

    public boolean supprimer(Utilisateur utilisateur) {
        return utilisateurDAO.delete(utilisateur.getId());
    }

    public Utilisateur trouverParId(int id) {
        return utilisateurDAO.find(id).orElse(null);
    }
}
