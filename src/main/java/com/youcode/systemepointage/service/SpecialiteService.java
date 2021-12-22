package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Specialite;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class SpecialiteService {
    private final GenericDAO<Specialite, Integer> specialiteDAO;

    public Specialite trouver(Specialite specialite) {
        return specialiteDAO.find(specialite.getId())
                .orElseThrow(() -> new RuntimeException("Specialite introuvable"));
    }

}
