package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Promotion;

public class PromotionService {
    private GenericDAO<Promotion, Integer> promotionDAO;

    public void ajouter(Promotion promotion) {
        promotionDAO.create(promotion);
    }

    public void modifier(Promotion promotion) {
        promotionDAO.update(promotion);
    }

    public void supprimer(Promotion promotion) {
        promotionDAO.delete(promotion.getId());
    }
}
