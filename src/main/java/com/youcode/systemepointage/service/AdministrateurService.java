package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.AdministrateurDAOImp;
import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Administrateur;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.Collection;

public class AdministrateurService extends UtilisateurService {
    private final GenericDAO<Administrateur, Integer> administrateurDAO = new AdministrateurDAOImp();

    @Override
    public Administrateur ajouter(Utilisateur administrateur) {
        return administrateurDAO.create((Administrateur) administrateur);
    }

    @Override
    public Administrateur modifier(Utilisateur administrateur) {
        return administrateurDAO.update((Administrateur) administrateur);
    }

    @Override
    public Collection<Administrateur> trouverTous() {
        return administrateurDAO.findAll();
    }

    @Override
    public Utilisateur trouverParId(int id) {
        return administrateurDAO.find(id)
                .orElseThrow(() -> new RuntimeException("Administrateur non trouvé"));
    }
}
