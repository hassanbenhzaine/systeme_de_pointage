package com.youcode.systemepointage;

import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.service.UtilisateurService;

public class Main {

    public static void main(String[] args){
//        RoleService role = new RoleService();

        Role admin = Role.builder().nom("ADMIN").build();

        Adresse hassandr = Adresse.builder().adresse1("avenue de la liberté").adresse2("20").codePostal(12030).ville("Maroc").pays("Rabat-sale-kenitra").build();

        UtilisateurService utilisateurService = new UtilisateurService();
        utilisateurService.seEnregistrer("hassan",
                "benhzaine",
                "cbenhzaine@gmail.com",
                "123456789",
                "0607873886",
                hassandr,
                admin
        );



        



    }
}