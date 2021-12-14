package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse implements Serializable {
    private int id;
    private String adresse1;
    private String adresse2;
    private int codePostal;
    private String pays;
    private String region;
    private String ville;
}
