package com.youcode.systemepointage.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    T create(T t);
    Optional<T> find(ID id);
    List<T> findAll();
    T update(T t);
    boolean delete(ID id);
}
