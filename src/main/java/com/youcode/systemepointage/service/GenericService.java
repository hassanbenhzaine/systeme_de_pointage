package com.youcode.systemepointage.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface GenericService<T, PK extends Serializable> {
    T create(T t);
    Optional<T> find(PK id);
    Collection<T> findAll();
    T update(T t);
    boolean delete(PK id);
}
