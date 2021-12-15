package com.youcode.systemepointage;

import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.service.UtilisateurService;

public class Main {

    public static void main(String[] args){
        UtilisateurService utilisateurService = new UtilisateurService();
        utilisateurService.seEnregistrer("hassan",
                "benhzaine",
                "cbenhzaine@gmail.com",
                "123456789",
                "0607873886",
                new Adresse("avenue de la liberté", "20", 12030, "Maroc",
                        "Rabat-sale-kenitra", "Rabat"),
                new Role("Administrateur")
        );
        



    }
}