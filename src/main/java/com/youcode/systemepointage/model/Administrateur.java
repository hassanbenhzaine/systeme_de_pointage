package com.youcode.systemepointage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@AllArgsConstructor
@SuperBuilder
@Data
public class Administrateur extends Utilisateur implements Serializable {
}
