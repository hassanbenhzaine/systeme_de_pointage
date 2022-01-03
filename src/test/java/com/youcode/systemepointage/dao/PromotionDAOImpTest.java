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
    private Connection connection;
    PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
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

        Promotion promotion =promotionDAOImp.create(new Promotion(LocalDate.now(),LocalDate.now(),"new Class"));
        if (promotion != null)
            assertTrue(true );
        else
            assertTrue(false );
    }


    @Test
    void find() {
        Optional<Promotion> acualPromotion = promotionDAOImp.find(1);
        assertTrue(acualPromotion.isPresent());
    }

    @Test
    void findAll() {
        List<Promotion> promotions =  promotionDAOImp.findAll();
        int acualPromotionSize = promotions.size();
        int expectedPromotionSize = 9;
        assertEquals(expectedPromotionSize , acualPromotionSize);
    }

    @Test
    void update() {
        Promotion expectedPromotion = promotionDAOImp.update(new Promotion(0,LocalDate.now(),LocalDate.now(),"newjddj Class"));
        if (expectedPromotion != null)
            assertTrue(true );
        else
            assertTrue(false );
    }

    @Test
    void delete() {
        Boolean actualStatusPromotionDIo = promotionDAOImp.delete(11110);
        assertTrue(actualStatusPromotionDIo);
    }
}