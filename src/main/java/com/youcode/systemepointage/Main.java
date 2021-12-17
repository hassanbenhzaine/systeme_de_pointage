package com.youcode.systemepointage;

import com.youcode.systemepointage.dao.AdresseDAOImp;
import com.youcode.systemepointage.dao.RoleDAOImp;
import com.youcode.systemepointage.dao.UtilisateurDAOImp;
import com.youcode.systemepointage.model.*;
import com.youcode.systemepointage.service.*;

public class Main {

    public static void main(String[] args){

        UtilisateurService a = new AdministrateurService(AdministrateurService.builder().adresseService());
    }
}