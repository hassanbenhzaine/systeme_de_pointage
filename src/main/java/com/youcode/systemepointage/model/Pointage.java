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
public class Pointage implements Serializable {
    private Integer id;
    private LocalDateTime dateEtHeure;
    private Integer utilisateurId;
}
