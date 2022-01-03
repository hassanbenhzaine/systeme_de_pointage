package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.PromotionDAOImp;
import com.youcode.systemepointage.model.Administrateur;
import com.youcode.systemepointage.model.Promotion;

import java.util.Collection;
import java.util.Optional;

public class PromotionService {
    private GenericDAO<Promotion, Integer> promotionDAO = new PromotionDAOImp();



    public void ajouter(Promotion promotion) {
        promotionDAO.create(promotion);
    }

    public Promotion modifier(Promotion promotion) {
        promotionDAO.update(promotion);
        return promotion;
    }
    public Optional<Promotion> getByid(int id) {
        promotionDAO.find(id);
        return  Optional.empty();
    }

    public Collection<Promotion> trouverTous() {
        return promotionDAO.findAll();
    }
    public boolean supprimer(Integer id) {
        promotionDAO.delete(id);
        return true;
    }
}
