package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@SuperBuilder
public class Etudiant extends Utilisateur implements Serializable {
    private Promotion promotion;
    private Classe classe;
    private Specialite specialite;
    private Formateur formateur;
}
