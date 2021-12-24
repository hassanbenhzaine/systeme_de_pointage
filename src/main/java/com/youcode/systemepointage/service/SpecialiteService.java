package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.SpecialiteDAOImp;
import com.youcode.systemepointage.model.Specialite;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class SpecialiteService {
    private final GenericDAO<Specialite, Integer> specialiteDAO = new SpecialiteDAOImp();

    public Specialite create(Specialite specialite){
        return specialiteDAO.create(specialite);
    }

    public Specialite update(Specialite specialite){
        return specialiteDAO.update(specialite);
    }

    public Optional<Specialite> find(int id){
        return specialiteDAO.find(id);
    }

    public List<Specialite> findAll(){
        return (List<Specialite>) specialiteDAO.findAll();
    }

//    public Specialite trouver(Specialite specialite) {
//        return specialiteDAO.find(specialite.getId())
//                .orElseThrow(() -> new RuntimeException("Specialite introuvable"));
//    }

}
