package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Pointage;

import java.util.List;
import java.util.Optional;

public interface PointageDAO {
    Pointage create(Pointage pointage);
    Optional<Pointage> find(int id);
    List<Pointage> findAll();
    Pointage update(Pointage pointage);
    Pointage delete(Pointage pointage);
}
