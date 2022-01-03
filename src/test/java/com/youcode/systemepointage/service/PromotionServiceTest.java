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
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ajouter() {
        promotionService.ajouter(new Promotion(LocalDate.now(),LocalDate.now(),"new Class"));
        List<Promotion> promotions = (List<Promotion>) promotionService.trouverTous();
        int acualPromotionSize = promotions.size();
        int expectedPromotionSize = 14;
        assertEquals(expectedPromotionSize , acualPromotionSize);
    }

    @Test
    void modifier() {
        Promotion expectedPromotion = new Promotion(11,LocalDate.now(),LocalDate.now(),"newjj Class");
        Promotion actualStatusPromotionDIo = promotionService.modifier(expectedPromotion);
        assertEquals(actualStatusPromotionDIo , expectedPromotion);
    }

    @Test
    void getByid() {
        Boolean expectedPromotionSize = true;
        Optional<Promotion> acualPromotion = promotionService.getByid(5);
        System.out.println(acualPromotion);
        assertEquals(expectedPromotionSize , acualPromotion.isPresent());
    }

    @Test
    void trouverTous() {
        List<Promotion> promotions = (List<Promotion>) promotionService.trouverTous();
        int acualPromotionSize = promotions.size();
        int expectedPromotionSize = 14;
        assertEquals(expectedPromotionSize , acualPromotionSize);
    }

    @Test
    void supprimer() {
        Boolean actualStatusPromotionDIo = promotionService.supprimer(11);
        Boolean exectedUPdateStatusPromotionDIo = true ;
        assertEquals(actualStatusPromotionDIo , exectedUPdateStatusPromotionDIo);
    }
}