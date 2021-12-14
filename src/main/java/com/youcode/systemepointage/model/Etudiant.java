package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Etudiant extends Utilisateur implements Serializable {
    private Promotion promotion;
}
