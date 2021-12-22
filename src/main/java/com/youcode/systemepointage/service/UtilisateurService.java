package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.UtilisateurDAOImp;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;


public class UtilisateurService {
    private final GenericDAO<Utilisateur, Integer> utilisateurDAO = new UtilisateurDAOImp();
    private final RoleService roleService = new RoleService();
    private final AdresseService adresseService = new AdresseService();

    public boolean seConnecter(Utilisateur utilisateur) {
       return utilisateurDAO.findAll().parallelStream()
        .filter(u -> u.getEmail().equals(utilisateur.getEmail())
                && u.getMotDePasse().equals(utilisateur.getMotDePasse()))
               .anyMatch( x -> true);
    }

    public boolean seEnregistrer(Utilisateur utilisateur) {
        if(utilisateurDAO.create(utilisateur) != null) {
            return true;
        }
        return false;
    }

    public Utilisateur trouverParEmail(Utilisateur utilisateur) {
        return utilisateurDAO.findAll().parallelStream()
                .filter(u -> u.getEmail().equals(utilisateur.getEmail()))
                .findFirst().orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public boolean desactiver(Utilisateur utilisateur) {
        utilisateur.setStatut(false);
        if(utilisateurDAO.update(utilisateur) != null) {
            return true;
        }
        return false;
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
        return utilisateurDAO.find(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }
}
