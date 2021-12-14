package com.youcode.systemepointage.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Evenement implements Serializable {
    private LocalDateTime debut;
    private LocalDateTime fin;
    private String nom;
    private boolean proposed;
}
