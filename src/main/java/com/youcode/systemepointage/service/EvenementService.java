package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.EvenementDAO;
import com.youcode.systemepointage.dao.EvenementDAOImp;
import com.youcode.systemepointage.dao.PointageDAOImp;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EvenementService {
    private final EvenementDAO evenementDAO;
    private static PointageService instance;
/*
    public static EvenementService getInstance(){
        if(instance == null){
            instance = new EvenementService();
        }
        return instance;
    }
    private EvenementService() {
        evenementDAO = new EvenementDAOImp();
    }

 */

}
