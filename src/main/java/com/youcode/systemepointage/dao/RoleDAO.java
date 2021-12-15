package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Role;

import java.util.Optional;

public interface RoleDAO extends GenericDAO<Role, Integer> {
    Optional<Role> findByName(String name);
}
