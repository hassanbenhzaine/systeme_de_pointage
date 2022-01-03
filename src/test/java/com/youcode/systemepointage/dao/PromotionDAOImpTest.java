package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.shared.ConnectionFactoryTest;
import com.youcode.systemepointage.model.Promotion;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PromotionDAOImpTest {

    private ConnectionFactoryTest connectionFactoryTest = new ConnectionFactoryTest();
    private PromotionDAOImp promotionDAOImp ;
    private Connection connection;

    public void setUp() throws Exception {
        connection = connectionFactoryTest.getConnection();
        promotionDAOImp = new PromotionDAOImp(connection);
    }

    public void tearDown() throws Exception {
        connection = null;
        promotionDAOImp= null;
    }
    @Test
    void create() {
        PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
        promotionDAOImp.create(new Promotion(LocalDate.now(),LocalDate.now(),"new Class"));
        List<Promotion> promotions = promotionDAOImp.findAll();
        int acualPromotionSize = promotions.size();
        int expectedUserSize = 9;
        assertEquals(expectedUserSize , acualPromotionSize);
    }

    @Test
    void find() {
        PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
        Promotion newPromotion = new Promotion(11,LocalDate.now(),LocalDate.now(),"new Class");
        Optional<Promotion> acualPromotion = promotionDAOImp.find(11);
        assertEquals(newPromotion , acualPromotion.get());
    }

    @Test
    void findAll() {
        PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
        List<Promotion> promotions =  promotionDAOImp.findAll();
        int acualPromotionSize = promotions.size();
        int expectedUserSize = 9;
        assertEquals(expectedUserSize , acualPromotionSize);
    }

    @Test
    void update() {
        PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
        Promotion expectedPromotion = new Promotion(11,LocalDate.now(),LocalDate.now(),"newjj Class");
        Promotion actualStatusPromotionDIo = promotionDAOImp.update(expectedPromotion);
        assertEquals(actualStatusPromotionDIo , expectedPromotion);
    }

    @Test
    void delete() {
        PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
        Boolean actualStatusUserDIo = promotionDAOImp.delete(11);
        Boolean exectedUPdateStatusUserDIo = true ;
        assertEquals(actualStatusUserDIo , exectedUPdateStatusUserDIo);
    }
}