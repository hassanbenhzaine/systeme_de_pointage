package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.EtudiantDAOImp;
import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Classe;
import com.youcode.systemepointage.model.Etudiant;
import com.youcode.systemepointage.model.Promotion;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.Collection;

public class EtudiantService extends UtilisateurService{
    private final GenericDAO<Etudiant, Integer> etudiantDAO = new EtudiantDAOImp();

    @Override
    public Collection<Etudiant> trouverTous() {
        return etudiantDAO.findAll();
    }

    @Override
    public Etudiant ajouter(Utilisateur etudiant) {
        return etudiantDAO.create((Etudiant) etudiant);
    }

    @Override
    public Etudiant modifier(Utilisateur etudiant) {
        return etudiantDAO.update((Etudiant) etudiant);
    }

    @Override
    public Utilisateur trouverParId(int id) {
        return etudiantDAO.find(id)
                .orElse(null);
    }

    public Long effectifParPromotion(Promotion promotion) {
        return etudiantDAO.findAll().stream().parallel()
                .filter(etudiant -> etudiant.getPromotion().getId().equals(promotion.getId()))
                .count();
    }

    public Long nbrGarconsParPromotion(Promotion promotion) {
        return etudiantDAO.findAll().stream().parallel()
                .filter(etudiant -> etudiant.getPromotion().getId().equals(promotion.getId())
                        && etudiant.getSexe().equals('M'))
                .count();
    }

    public Long nbrFillesParPromotion(Promotion promotion) {
        return etudiantDAO.findAll().stream().parallel()
                .filter(etudiant -> etudiant.getPromotion().getId().equals(promotion.getId())
                        && etudiant.getSexe().equals('F'))
                .count();
    }

    public Long effectifParClasse(Classe classe) {
        return etudiantDAO.findAll().stream().parallel()
                .filter(etudiant -> etudiant.getClasse().getId().equals(classe.getId()))
                .count();
    }
}
