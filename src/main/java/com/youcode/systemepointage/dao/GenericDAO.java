package com.youcode.systemepointage.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {
    T create(T t);
    Optional<T> find(int id);
    List<T> findAll();
    T update(T t);
    boolean delete(int id);
}
