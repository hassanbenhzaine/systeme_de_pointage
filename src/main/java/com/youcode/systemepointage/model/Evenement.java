package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Evenement implements Serializable {
    private Integer id;
    private LocalDateTime debut;
    private LocalDateTime fin;
    private String nom;
    private String description;
    private Boolean proposer;
}
