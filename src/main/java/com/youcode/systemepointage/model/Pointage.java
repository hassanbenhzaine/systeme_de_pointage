package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pointage implements Serializable {
    private Integer id;
    private LocalDateTime dateEtHeure;
    private Utilisateur utilisateur;

    public Pointage(LocalDateTime dateEtHeure, Utilisateur utilisateur) {
        this.dateEtHeure = dateEtHeure;
        this.utilisateur = utilisateur;
    }

    public Pointage(LocalDateTime dateEtHeure) {
        this.dateEtHeure = dateEtHeure;
    }
}
