package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.EtudiantDAOImp;
import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Etudiant;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

public class EtudiantService extends UtilisateurService{
    private final GenericDAO<Etudiant, Integer> etudiantDAO = new EtudiantDAOImp();

    @Override
    public Collection<Etudiant> trouverTous() {
        return etudiantDAO.findAll();
    }

    @Override
    public Etudiant ajouter(Utilisateur etudiant) {
        return etudiantDAO.create((Etudiant) etudiant);
    }

    @Override
    public Etudiant modifier(Utilisateur etudiant) {
        return etudiantDAO.update((Etudiant) etudiant);
    }

    @Override
    public Utilisateur trouverParId(int id) {
        return etudiantDAO.find(id)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé"));
    }
}
