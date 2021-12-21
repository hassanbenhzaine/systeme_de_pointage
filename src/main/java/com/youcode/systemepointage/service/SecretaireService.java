package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.model.Secretaire;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class SecretaireService {
    private final GenericDAO<Secretaire, Integer> secretaireDAO;

}
