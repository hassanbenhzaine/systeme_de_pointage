package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe implements Serializable {
    private int id;
    private LocalTime debutJournee;
    private LocalTime finJournee;
    private String nom;
}
