package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.AdresseDAO;
import com.youcode.systemepointage.dao.AdresseDAOImp;
import com.youcode.systemepointage.model.Adresse;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class AdresseService {
    private final AdresseDAO adresseDAO;

    public void ajouter(Adresse adresse) {
        adresseDAO.create(adresse);
    }
}
