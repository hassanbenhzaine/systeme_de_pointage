package com.youcode.systemepointage.dao;


import com.youcode.systemepointage.model.ChefFabrique;

import java.util.List;
import java.util.Optional;

public class ChefFabriqueDAOImpl implements ChefFabriqueDAO {
    private final String tableName = "ChefFabrique";

    @Override
    public ChefFabrique create(ChefFabrique chefFabrique) {
        return null;
    }

    @Override
    public Optional<ChefFabrique> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<ChefFabrique> findAll() {
        return null;
    }

    @Override
    public ChefFabrique update(ChefFabrique chefFabrique) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}

