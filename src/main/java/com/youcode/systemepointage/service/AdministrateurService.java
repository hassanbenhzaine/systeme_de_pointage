package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.AdministrateurDAO;
import com.youcode.systemepointage.dao.UtilisateurDAO;
import com.youcode.systemepointage.model.Administrateur;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class AdministrateurService extends UtilisateurService{
    private final AdministrateurDAO administrateurDAO;

    @Override
    public void seEnregistrer(Utilisateur administrateur, Adresse adresse, Role role) {
        Role foundRole = super.getRoleService().trouverRole(role.getNom());
        administrateur.setRole(foundRole);
        Utilisateur createdAdministrateur = administrateurDAO.create((Administrateur) administrateur);
        adresse.setUtilisateur(createdAdministrateur);
        super.getAdresseService().ajouter(adresse);
    }
}
