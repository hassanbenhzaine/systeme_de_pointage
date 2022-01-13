package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.AdresseDAOImp;
import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Adresse;
import lombok.experimental.SuperBuilder;

import java.util.Collection;


public class AdresseService {
    private final GenericDAO<Adresse, Integer> adresseDAO = new AdresseDAOImp();

    public Adresse ajouter(Adresse adresse) {
        return adresseDAO.create(adresse);
    }

    public Adresse modifier(Adresse adresse) {
        return adresseDAO.update(adresse);
    }

    public boolean supprimer(Adresse adresse) {
        return adresseDAO.delete(adresse.getId());
    }

    public Adresse trouverParId(Integer id) {
        return adresseDAO.find(id).orElseThrow(() -> new RuntimeException("Adresse introuvable"));
    }

    public Collection<Adresse> trouverTous(){
        return adresseDAO.findAll();
    }
}
