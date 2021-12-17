package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.UtilisateurDAO;
import com.youcode.systemepointage.dao.UtilisateurDAOImp;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@Data
public class UtilisateurService {
    private final UtilisateurDAO utilisateurDAO;
    private final RoleService roleService;
    private final AdresseService adresseService;

    public void seConnecter(Utilisateur utilisateur) {
        utilisateurDAO.findByEmailAndPassword(utilisateur.getEmail(), utilisateur.getMotDePasse())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public void seEnregistrer(Utilisateur utilisateur, Adresse adresse, Role role) {
        Role foundRole = roleService.trouverRole(role.getNom());
        utilisateur.setRole(foundRole);
        Utilisateur createdUtilisateur = utilisateurDAO.create(utilisateur);
        adresse.setUtilisateur(createdUtilisateur);
        adresseService.ajouter(adresse);
    }

    public Utilisateur trouverUtilisateurParEmail(Utilisateur utilisateur) {
        return utilisateurDAO.findByEmail(utilisateur.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

}
