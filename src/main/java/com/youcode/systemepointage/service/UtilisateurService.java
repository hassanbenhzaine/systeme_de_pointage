package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.UtilisateurDAO;
import com.youcode.systemepointage.dao.UtilisateurDAOImp;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UtilisateurService {
    private final UtilisateurDAO utilisateurDAO;
    private final RoleService roleService;
    private final AdresseService adresseService;
    private static UtilisateurService instance = null;

    public static UtilisateurService getInstance(){
        if(instance==null){
            instance = new UtilisateurService();
        }
        return instance;
    }

    public UtilisateurService() {
        utilisateurDAO = new UtilisateurDAOImp();
        roleService = RoleService.getInstance();
        adresseService = AdresseService.getInstance();
    }

    public void seConnecter(String email, String motDePasse) {
        utilisateurDAO.findByEmailAndPassword(email, motDePasse)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public void seEnregistrer(Utilisateur utilisateur, Adresse adresse, Role role) {
        utilisateur.setRole(role);
        Utilisateur createdUtilisateur = utilisateurDAO.create(utilisateur);

        Role foundRole = roleService.trouverRole(role.getNom());

        createdUtilisateur.setRole(foundRole);
        utilisateurDAO.update(createdUtilisateur);

        adresse.setUtilisateur(createdUtilisateur);

        adresseService.ajouter(adresse);
    }

    public Utilisateur trouverUtilisateur(String email) {
        return utilisateurDAO.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

}
