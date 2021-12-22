package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Etudiant;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class EtudiantService extends UtilisateurService{

    public void desactiver(Etudiant etudiant) {
        super.desactiver(etudiant);
    }
}
