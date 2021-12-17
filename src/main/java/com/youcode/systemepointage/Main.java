package com.youcode.systemepointage;

import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.RoleService;
import com.youcode.systemepointage.service.UtilisateurService;

public class Main {

    public static void main(String[] args){
        RoleService role = new RoleService();
        Role adminRole = role.trouverRole("ADMIN");

        Adresse hassanaddress = Adresse.builder()
                .adresse1("avenue de la liberté")
                .adresse2("20").codePostal(12030)
                .ville("Maroc")
                .pays("Rabat-sale-kenitra")
                .build();


        UtilisateurService.getInstance()
                .seEnregistrer(Utilisateur.builder()
                        .nom("hassan")
                        .prenom("benhzaine")
                        .email("cbenhzaine@gmail.com")
                        .motDePasse("123456")
                        .telephone("0612345678")
                        .statut(true)
                        .build(),
                hassanaddress,
                adminRole
        );

    }
}