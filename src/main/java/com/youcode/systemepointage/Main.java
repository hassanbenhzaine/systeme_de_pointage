package com.youcode.systemepointage;

import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.UtilisateurService;

public class Main {

    public static void main(String[] args) {


        Utilisateur createdUtilisateur = new UtilisateurService().ajouter(new Utilisateur());
    }

}
