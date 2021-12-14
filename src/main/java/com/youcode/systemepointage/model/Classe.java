package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe implements Serializable {
    private LocalTime debutJournee;
    private LocalTime finJournee;
    private String nom;
}
