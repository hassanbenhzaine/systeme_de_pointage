package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Formateur;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@SuperBuilder
public class FormateurService extends UtilisateurService{
    private GenericDAO<Formateur, Integer> formateurDAO;

    public void ajouter(Formateur formateur) {
        formateurDAO.create(formateur);
    }

    public void modifier(Formateur formateur) {
        formateurDAO.update(formateur);
    }

    public Collection<Formateur> getTous() {
        return formateurDAO.findAll();
    }

    @Override
    public void ajouter(Utilisateur utilisateur) {
        formateurDAO.create((Formateur) utilisateur);
    }

    @Override
    public void modifier(Utilisateur utilisateur) {
        formateurDAO.create((Formateur) utilisateur);
    }
}
