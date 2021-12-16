package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classe implements Serializable {
    private Integer id;
    private LocalTime debutJournee;
    private LocalTime finJournee;
    private String nom;
}
