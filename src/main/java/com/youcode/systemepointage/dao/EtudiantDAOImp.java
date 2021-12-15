package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Etudiant;

import java.util.List;
import java.util.Optional;

public class EtudiantDAOImp implements EtudiantDAO {
    @Override
    public Etudiant create(Etudiant etudiant) {
        return null;
    }

    @Override
    public Optional<Etudiant> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Etudiant> findAll() {
        return null;
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
