package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialite implements Serializable {
    private Integer id;
    private String nom;

    public Specialite(String nom) {
        this.nom = nom;
    }
}
