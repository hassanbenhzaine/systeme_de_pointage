package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Role {
    private Integer id;
    private String nom;

    public Role(String nom) {
        this.nom = nom;
    }

}
