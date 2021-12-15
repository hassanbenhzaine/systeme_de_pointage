package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class JournalEvenement implements Serializable {
    private int id;
    private LocalDateTime debut;
    private LocalDateTime fin;
    private String nom;
    private Secretaire secretaire;
    private Evenement evenement;

    public JournalEvenement(LocalDateTime debut, LocalDateTime fin, String nom, Secretaire secretaire, Evenement evenement) {
        this.debut = debut;
        this.fin = fin;
        this.nom = nom;
        this.secretaire = secretaire;
        this.evenement = evenement;
    }
}
