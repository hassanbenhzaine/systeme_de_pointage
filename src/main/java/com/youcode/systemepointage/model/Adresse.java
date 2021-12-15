package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse implements Serializable {
    private Integer id;
    private String adresse1;
    private String adresse2;
    private Integer codePostal;
    private String pays;
    private String region;
    private String ville;
    private Utilisateur utilisateur;

    public Adresse(String adresse1, String adresse2, Integer codePostal, String pays, String region, String ville) {
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.codePostal = codePostal;
        this.pays = pays;
        this.region = region;
        this.ville = ville;
    }
}
