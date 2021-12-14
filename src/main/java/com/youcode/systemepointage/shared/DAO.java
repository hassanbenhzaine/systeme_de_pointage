package com.youcode.systemepointage.shared;

import com.youcode.systemepointage.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T create(T t);
    Optional<T> find(int id);
    List<T> findAll();
    T update(T t);
    T delete(T t);

}
