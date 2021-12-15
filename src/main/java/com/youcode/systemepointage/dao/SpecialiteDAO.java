package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Specialite;

import java.util.List;
import java.util.Optional;

public interface SpecialiteDAO extends GenericDAO<Specialite> {
    Specialite create(Specialite specialite);
    Optional<Specialite> find(int id);
    List<Specialite> findAll();
    Specialite update(Specialite specialite);
    boolean delete(int id);
}
