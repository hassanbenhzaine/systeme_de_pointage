package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class JournalEvenement implements Serializable {
    private LocalDateTime ajoute;
    private LocalDateTime suppression;
    private LocalDateTime modification;
    private Utilisateur utilisateur;
    private Evenement evenement;
}
