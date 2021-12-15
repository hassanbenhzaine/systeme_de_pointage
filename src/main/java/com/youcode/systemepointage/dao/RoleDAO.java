package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDAO {
    Role create(Role role);
    Optional<Role> find(int id);
    List<Role> findAll();
    Role update(Role role);
    Role delete(Role role);

}
