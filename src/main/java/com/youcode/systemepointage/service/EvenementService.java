package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Evenement;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class EvenementService {
    private final GenericDAO<Evenement, Integer> evenementDAO;
    // private static PointageService instance;

    public Evenement create(Evenement evenement){
        return evenementDAO.create(evenement);
    }

    public Evenement update(Evenement evenement){
        return evenementDAO.update(evenement);
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
