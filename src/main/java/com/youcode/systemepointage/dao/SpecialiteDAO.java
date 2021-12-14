package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Specialite;

import java.util.List;
import java.util.Optional;

public interface SpecialiteDAO {
    Specialite create(Specialite t);
    Optional<Specialite> find(int id);
    List<Specialite> findAll();
    Specialite update(Specialite t);
    Specialite delete(Specialite t);
}
