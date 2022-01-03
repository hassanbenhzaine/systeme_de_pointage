package com.youcode.systemepointage;

import com.youcode.systemepointage.dao.ClasseDAOImp;
import com.youcode.systemepointage.dao.PointageDAOImp;
import com.youcode.systemepointage.dao.PromotionDAOImp;
import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Classe;
import com.youcode.systemepointage.model.Promotion;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.UtilisateurService;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        //PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
        //promotionDAOImp.create(new Promotion(LocalDate.now(),LocalDate.now(),"Last Yassine"));
        ClasseDAOImp classeDAOImp = new ClasseDAOImp();
        classeDAOImp.create(new Classe(LocalTime.now(),LocalTime.now(),"new Class"));
        // System.out.println(promotionDAOImp.find(5));
       // promotionDAOImp.update(new Promotion(5,LocalDate.now(),LocalDate.now(),"new Yassine"));
        //promotionDAOImp.delete(3);
    }

}
