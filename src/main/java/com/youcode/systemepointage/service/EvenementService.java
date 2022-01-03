package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.EvenementDAOImp;
import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Evenement;
import com.youcode.systemepointage.model.JournalEvenement;
import com.youcode.systemepointage.model.Utilisateur;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class EvenementService {
    private final GenericDAO<Evenement, Integer> evenementDAO = new EvenementDAOImp();
    private final JournalEvenementService journalEvenementService = new JournalEvenementService();
    // private static PointageService instance;

    public Evenement create(Evenement evenement, Utilisateur utilisateur){
        Evenement createdEvenement = evenementDAO.create(evenement);
        JournalEvenement journalEvenement = JournalEvenement.builder()
                .evenement(createdEvenement)
                .utilisateur(utilisateur)
                .ajoute(LocalDateTime.now())
                .build();
        journalEvenementService.ajouter(journalEvenement);
        return createdEvenement;
    }

    public Evenement update(Evenement evenement, Utilisateur utilisateur){
        Evenement updateEvenement = evenementDAO.update(evenement);
        JournalEvenement journalEvenement = JournalEvenement.builder()
                .evenement(updateEvenement)
                .utilisateur(utilisateur)
                .modification(LocalDateTime.now())
                .build();
        journalEvenementService.modifier(journalEvenement);
        return updateEvenement;
    }

    public Optional<Evenement> find(int id){
        return evenementDAO.find(id);
    }

    public List<Evenement> findAll(){
        return (List<Evenement>) evenementDAO.findAll();
     }

    public boolean delete(int id) {
        return evenementDAO.delete(id);
     }

    /*

    public static EvenementService getInstance(){
        if(instance == null){
            instance = new EvenementService();
        }
        return instance;
    }
    private EvenementService() {
        evenementDAO = new EvenementDAOImp();
    }

 */

}
