package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable {
    private Integer id;
    private String nom, prenom, email, motDePasse, telephone;
    private Role role;
    private Boolean statut;
    private Character sexe;
}