package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promotion implements Serializable {
    private Integer id;
    private LocalDate debut;
    private LocalDate fin;
    private String nom;
}
