package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.JournalEvenementDAOImp;
import com.youcode.systemepointage.model.JournalEvenement;

import java.util.Collection;

public class JournalEvenementService {
    private final GenericDAO<JournalEvenement, Integer> journalEvenementDAO = new JournalEvenementDAOImp();

    public JournalEvenement ajouter(JournalEvenement journalEvenement){
        return journalEvenementDAO.create(journalEvenement);
    }

    public boolean supprimer(JournalEvenement journalEvenement){
        return journalEvenementDAO.delete(journalEvenement.getId());
    }
    public JournalEvenement modifier(JournalEvenement journalEvenement){
        return journalEvenementDAO.update(journalEvenement);
    }
    public JournalEvenement trouverParId(int id){
        return journalEvenementDAO.find(id).orElse(null);
    }

    public Collection<JournalEvenement> trouverTout(){
        return journalEvenementDAO.findAll();
    }
}
