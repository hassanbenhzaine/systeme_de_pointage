package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<Pointage> pointagesParUtilisateur(Utilisateur utilisateur){
        return pointageDAO.findAll().parallelStream()
                .filter(pointage -> pointage.getUtilisateur().getId() == utilisateur.getId())
                .toList();
    }

    public void supprimerPointage(Pointage pointage){
        pointageDAO.delete(pointage.getId());
    }

    public void modifierPointage(Pointage pointage){
        pointageDAO.update(pointage);
    }
}
