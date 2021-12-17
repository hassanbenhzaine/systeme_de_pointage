package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.SecretaireDAO;
import com.youcode.systemepointage.dao.SecretaireDAOImp;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class SecretaireService {
    private final SecretaireDAO secretaireDAO;

}
