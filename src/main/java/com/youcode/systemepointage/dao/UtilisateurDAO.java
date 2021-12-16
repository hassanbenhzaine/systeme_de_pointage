package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Utilisateur;

import java.util.Optional;

public interface UtilisateurDAO extends GenericDAO<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmailAndPassword(String email, String motDePasse);
    Optional<Utilisateur> findByEmail(String email);
}
