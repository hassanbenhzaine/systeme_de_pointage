package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Etudiant;
import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Promotion;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Collection;

@AllArgsConstructor
@Builder
public class PointageService {
    private final GenericDAO<Pointage, Integer> pointageDAO;


    public void pointer(Utilisateur utilisateur){
        pointageDAO.create(
                Pointage.builder()
                .utilisateur(utilisateur)
                .dateEtHeure(LocalDateTime.now())
                .build()
        );
    }

    public Collection<Pointage> parUtilisateur(Utilisateur utilisateur){
        return pointageDAO.findAll().parallelStream()
                .filter(pointage -> pointage.getUtilisateur().getId() == utilisateur.getId())
                .toList();
    }

    public Collection<Pointage> etudiantParPromotion(Promotion promotion){
        return pointageDAO.findAll().parallelStream()
                .filter(pointage -> ((Etudiant) pointage.getUtilisateur())
                        .getPromotion().getId() == promotion.getId())
                .toList();
    }

    public void supprimer(Pointage pointage){
        pointageDAO.delete(pointage.getId());
    }

    public void modifier(Pointage pointage){
        pointageDAO.update(pointage);
    }
}
