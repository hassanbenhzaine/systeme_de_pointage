package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class JournalEvenement implements Serializable {
    private int id;
    private LocalDateTime debut;
    private LocalDateTime fin;
    private String nom;



}
