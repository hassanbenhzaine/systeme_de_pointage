package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Adresse implements Serializable {
    private Integer id;
    private String adresse1;
    private String adresse2;
    private Integer codePostal;
    private String pays;
    private String region;
    private String ville;
    private Utilisateur utilisateur;

}
