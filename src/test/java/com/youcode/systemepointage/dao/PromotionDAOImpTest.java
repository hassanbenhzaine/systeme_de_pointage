package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.config.TestConfig;
import com.youcode.systemepointage.model.Promotion;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PromotionDAOImpTest {

    private TestConfig testConfig = new TestConfig();
    private PromotionDAOImp promotionDAOImp ;
    private Connection connection;

    public void setUp() throws Exception {
        connection = testConfig.getConnection();
        promotionDAOImp = new PromotionDAOImp(connection);
    }

    public void tearDown() throws Exception {
        connection = null;
        promotionDAOImp= null;
    }
    @Test
    void create() {
        PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
        promotionDAOImp.create(new Promotion(LocalDate.now(),LocalDate.now(),"new Yasskine"));
        List<Promotion> promotions = promotionDAOImp.findAll();
        int acualUserSize = promotions.size();
        int expectedUserSize = 1;
        assertEquals(expectedUserSize , acualUserSize);
    }

    @Test
    void find() {
        PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
        Promotion newPromotion = new Promotion(6,LocalDate.now(),LocalDate.now(),"new Yasskine");
        Optional acualPromotion = promotionDAOImp.find(7);
        assertEquals(newPromotion , acualPromotion);
    }

    @Test
    void findAll() {
        PromotionDAOImp promotionDAOImp = new PromotionDAOImp();
        List<Promotion> promotions =  promotionDAOImp.findAll();
        int acualUserSize = promotions.size();
        int expectedUserSize = 3;
        assertEquals(expectedUserSize , acualUserSize);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}