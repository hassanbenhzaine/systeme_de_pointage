package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.PromotionDAOImp;
import com.youcode.systemepointage.model.Promotion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class PromotionServiceTest {
    private PromotionService promotionService = new PromotionService();

    @Test
    void ajouter() {
        Promotion promotion =promotionService.create(new Promotion(LocalDate.now(),LocalDate.now(),"new Class"));
        if (promotion != null)
            assertTrue(true );
        else
            assertTrue(false );
    }

    @Test
    void modifier() {
        Promotion expectedPromotion = promotionService.update(new Promotion(0,LocalDate.now(),LocalDate.now(),"newjddj Class"));
        if (expectedPromotion != null)
            assertTrue(true );
        else
            assertTrue(false );
    }

    @Test
    void getByid() {
        Optional<Promotion> acualPromotion = promotionService.find(1);
        assertTrue(acualPromotion.isPresent());
    }

    @Test
    void trouverTous() {
        List<Promotion> promotions = (List<Promotion>) promotionService.findAll();
        int acualPromotionSize = promotions.size();
        int expectedPromotionSize = 14;
        assertEquals(expectedPromotionSize , acualPromotionSize);
    }

    @Test
    void supprimer() {
        Boolean actualStatusPromotionDIo = promotionService.delete(1);
        assertTrue(actualStatusPromotionDIo);
    }
}