package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.PointageDAOImp;
import com.youcode.systemepointage.model.Etudiant;
import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Promotion;
import com.youcode.systemepointage.model.Utilisateur;

import java.time.LocalDateTime;
import java.util.Collection;

public class PointageService {
    private final GenericDAO<Pointage, Integer> pointageDAO = new PointageDAOImp();

    public Pointage pointer(Utilisateur utilisateur){
        return pointageDAO.create(
                Pointage.builder()
                .utilisateur(utilisateur)
                .dateEtHeure(LocalDateTime.now())
                .build()
        );
    }

    public Collection<Pointage> parUtilisateur(Utilisateur utilisateur){
        return pointageDAO.findAll().stream().parallel()
                .filter(pointage -> pointage.getUtilisateur().getId().equals(utilisateur.getId()))
                .toList();
    }

    public Collection<Pointage> etudiantParPromotion(Promotion promotion){
        return pointageDAO.findAll().stream().parallel()
                .filter(pointage -> ((Etudiant) pointage.getUtilisateur())
                        .getPromotion().getId().equals(promotion.getId()))
                .toList();
    }

    public boolean supprimer(Pointage pointage){
        return pointageDAO.delete(pointage.getId());
    }

    public Pointage modifier(Pointage pointage){
        return pointageDAO.update(pointage);
    }

    public Pointage trouverParId(int id) {
        return pointageDAO.find(id)
                .orElseThrow(() -> new RuntimeException("Pointage non trouvé"));
    }
}
