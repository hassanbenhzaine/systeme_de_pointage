package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Evenement;

import java.util.List;
import java.util.Optional;

public class EvenementDAOImp implements GenericDAO<Evenement, Integer> {
    @Override
    public Evenement create(Evenement evenement) {
        return null;
    }

    @Override
    public Optional<Evenement> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Evenement> findAll() {
        return null;
    }

    @Override
    public Evenement update(Evenement evenement) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
