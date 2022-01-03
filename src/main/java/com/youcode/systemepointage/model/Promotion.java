package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promotion implements Serializable {
    private Integer id;
    private LocalDate debut, fin;
    private String nom;

    public Promotion(LocalDate debut, LocalDate fin, String nom) {
        this.debut = debut;
        this.fin = fin;
        this.nom = nom;
    }
}
