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
    private Integer id, codePostal;
    private String adresse1, adresse2, pays, region, ville;
    private Utilisateur utilisateur;

}
