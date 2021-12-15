package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;

import java.util.Optional;

public interface UtilisateurDAO extends GenericDAO<Utilisateur> {
    Optional<Utilisateur> findByEmailAndPassword(String email, String motDePasse);
    Utilisateur assignRole(Utilisateur utilisateur, Role role);
}
