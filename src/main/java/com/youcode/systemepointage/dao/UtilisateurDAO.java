package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurDAO {
    Utilisateur create(Utilisateur utilisateur);
    Optional<Utilisateur> find(int id);
    List<Utilisateur> findAll();
    Utilisateur update(Utilisateur utilisateur);
    Utilisateur delete(Utilisateur utilisateur);
    Optional<Utilisateur> findByEmailAndPassword(String email, String motDePasse);
    Utilisateur assignRole(Utilisateur utilisateur, Role role);
}
