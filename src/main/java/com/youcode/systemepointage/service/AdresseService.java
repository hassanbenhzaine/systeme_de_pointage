package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Adresse;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class AdresseService {
    private final GenericDAO<Adresse, Integer> adresseDAO;

    public void ajouter(Adresse adresse) {
        adresseDAO.create(adresse);
    }
}
