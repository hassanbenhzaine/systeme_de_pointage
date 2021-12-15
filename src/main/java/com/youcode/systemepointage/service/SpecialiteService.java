package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.SpecialiteDAO;
import com.youcode.systemepointage.dao.SpecialiteDAOImp;

public class SpecialiteService {
    private SpecialiteDAO specialiteDAO;

    public SpecialiteService() {
        this.specialiteDAO = new SpecialiteDAOImp();
    }
}
