package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.SecretaireDAO;
import com.youcode.systemepointage.dao.SecretaireDAOImp;

public class SecretaireService {
    private SecretaireDAO secretaireDAO;

    public SecretaireService() {
        this.secretaireDAO = new SecretaireDAOImp();
    }
}
