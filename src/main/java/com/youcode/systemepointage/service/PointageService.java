package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.PointageDAO;
import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PointageService {
    private PointageDAO pointageDAO;

    public void pointer(Utilisateur utilisateur){
        pointageDAO.find(utilisateur.getId()).ifPresent(pointage -> {
            pointage.setDateEtHeure(LocalDateTime.now());
            pointageDAO.create(pointage);
        });
    }
}
