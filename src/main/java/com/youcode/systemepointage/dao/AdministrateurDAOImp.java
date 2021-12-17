package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Administrateur;

import java.util.List;
import java.util.Optional;

public class AdministrateurDAOImp implements AdministrateurDAO {
    private final String tableName = "Administrateur";

    @Override
    public Administrateur create(Administrateur administrateur) {
        return null;
    }

    @Override
    public Optional<Administrateur> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Administrateur> findAll() {
        return null;
    }

    @Override
    public Administrateur update(Administrateur administrateur) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

}
