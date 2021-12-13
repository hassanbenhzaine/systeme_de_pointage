package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChefFabrique extends Utilisateur implements Serializable {
    private Date entreeFabrique;

    public ChefFabrique(int id, int telephone, String email, String motDePasse, String nom, String prenom, Adresse adresse, Date entreeFabrique) {
        super(id, telephone, email, motDePasse, nom, prenom, adresse);
        this.entreeFabrique = entreeFabrique;
    }
}
