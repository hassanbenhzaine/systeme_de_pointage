package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Role {
    private int id;
    private Roles nom;

    public Role(Roles nom) {
        this.nom = nom;
    }

}
