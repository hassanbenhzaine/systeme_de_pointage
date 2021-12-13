package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable {
    private int id;
    private int telephone;
    private String email;
    private String motDePasse;
    private String nom;
    private String prenom;
    private Adresse adresse;
}
