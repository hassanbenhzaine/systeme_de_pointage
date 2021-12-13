package com.youcode.systemepointage;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    boolean create(T t);
    Optional<T> find(int id);
    List<T> findAll();
    void update(T t);
    void delete(T t);

}
