package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Classe;

import java.util.List;
import java.util.Optional;

public class ClasseDAOImp implements GenericDAO<Classe, Integer> {
    @Override
    public Classe create(Classe classe) {
        return null;
    }

    @Override
    public Optional<Classe> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Classe> findAll() {
        return null;
    }

    @Override
    public Classe update(Classe classe) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
