package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evenement implements Serializable {
    private int id;
    private LocalDateTime debut;
    private LocalDateTime fin;
    private String nom;
    private String description;
    private boolean proposer;

    public Evenement(LocalDateTime debut, LocalDateTime fin, String nom, String description, boolean proposer) {
        this.debut = debut;
        this.fin = fin;
        this.nom = nom;
        this.description = description;
        this.proposer = proposer;
    }
}
