package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.FormateurDAOImp;
import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Formateur;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.Collection;


public class FormateurService extends UtilisateurService{
    private GenericDAO<Formateur, Integer> formateurDAO = new FormateurDAOImp();

    @Override
    public Collection<Formateur> trouverTous() {
        return formateurDAO.findAll();
    }

    @Override
    public Formateur ajouter(Utilisateur utilisateur) {
        return formateurDAO.create((Formateur) utilisateur);
    }

    @Override
    public Formateur modifier(Utilisateur utilisateur) {
        return formateurDAO.update((Formateur) utilisateur);
    }

    @Override
    public Utilisateur trouverParId(int id) {
        return formateurDAO.find(id).orElse(null);
    }
}
