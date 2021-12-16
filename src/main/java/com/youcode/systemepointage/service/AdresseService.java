package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.AdresseDAO;
import com.youcode.systemepointage.dao.AdresseDAOImp;
import com.youcode.systemepointage.model.Adresse;

public class AdresseService {
    private final AdresseDAO adresseDAO;
    private static AdresseService instance = null;

    public static AdresseService getInstance(){
        if(instance==null){
            instance = new AdresseService();
        }
        return instance;
    }

    public AdresseService() {
        adresseDAO = new AdresseDAOImp();
    }

    public void ajouter(Adresse adresse) {
        adresseDAO.create(adresse);
    }
}
