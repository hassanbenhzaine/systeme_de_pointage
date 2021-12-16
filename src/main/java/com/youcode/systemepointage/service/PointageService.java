package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.PointageDAO;
import com.youcode.systemepointage.dao.PointageDAOImp;
import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class PointageService {
    private final PointageDAO pointageDAO;

    public PointageService() {
        this.pointageDAO = new PointageDAOImp();
    }

    public void pointer(Utilisateur utilisateur){
        pointageDAO.create(
                Pointage.builder()
                .utilisateur(utilisateur)
                .dateEtHeure(LocalDateTime.now())
                .build()
        );
    }

    public List<Pointage> pointagesParUtilisateur(Utilisateur utilisateur){
        return pointageDAO.findAllByUser(utilisateur);
    }

    public void supprimerPointage(Pointage pointage){
        pointageDAO.delete(pointage.getId());
    }

    public void modifierPointage(Pointage pointage){
        pointageDAO.update(pointage);
    }
}
