package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.List;

public interface PointageDAO extends GenericDAO<Pointage, Integer> {
    List<Pointage> findAllByUser(Utilisateur utilisateur);
}
