package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.SpecialiteDAOImp;
import com.youcode.systemepointage.model.Specialite;
import lombok.AllArgsConstructor;
import lombok.Builder;


public class SpecialiteService {
    private final GenericDAO<Specialite, Integer> specialiteDAO = new SpecialiteDAOImp();

//    public Specialite trouver(Specialite specialite) {
//        return specialiteDAO.find(specialite.getId())
//                .orElseThrow(() -> new RuntimeException("Specialite introuvable"));
//    }

}
