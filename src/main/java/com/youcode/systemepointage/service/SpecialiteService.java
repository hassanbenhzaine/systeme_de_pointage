package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.SpecialiteDAO;
import com.youcode.systemepointage.dao.SpecialiteDAOImp;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class SpecialiteService {
    private final SpecialiteDAO specialiteDAO;

}
