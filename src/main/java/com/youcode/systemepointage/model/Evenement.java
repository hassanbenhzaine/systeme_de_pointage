package com.youcode.systemepointage.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Evenement implements Serializable {
    private int id;
    private LocalDateTime debut;
    private LocalDateTime fin;
    private String nom;
    private String description;
    private boolean proposed;
}
