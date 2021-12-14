package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Adresse;

import java.util.List;
import java.util.Optional;

public interface AdresseDAO{
    Adresse create(Adresse adresse);
    Optional<Adresse> find(int id);
    List<Adresse> findAll();
    Adresse update(Adresse adresse);
    Adresse delete(Adresse adresse);
}
