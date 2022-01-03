package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.PromotionDAOImp;
import com.youcode.systemepointage.model.Administrateur;
import com.youcode.systemepointage.model.Promotion;

import java.util.Collection;
import java.util.Optional;

public class PromotionService implements GenericService<Promotion, Integer>{
    private GenericDAO<Promotion, Integer> promotionDAO = new PromotionDAOImp();
    @Override
    public Promotion create(Promotion promotion) {
        return promotionDAO.create(promotion);
    }

    @Override
    public Optional<Promotion> find(Integer id) {
        return  promotionDAO.find(id);
    }

    @Override
    public Collection<Promotion> findAll() {
        return promotionDAO.findAll();
    }

    @Override
    public Promotion update(Promotion promotion) {
        return promotionDAO.update(promotion);
    }

    @Override
    public boolean delete(Integer id) {
        return promotionDAO.delete(id);
    }
}
