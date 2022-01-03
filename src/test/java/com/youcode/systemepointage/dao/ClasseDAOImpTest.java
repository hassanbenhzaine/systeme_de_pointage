package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Classe;
import com.youcode.systemepointage.shared.ConnectionFactoryTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClasseDAOImpTest {
    private ConnectionFactoryTest connectionFactoryTest = new ConnectionFactoryTest();
    private Connection connection;
    ClasseDAOImp classeDAOImp = new ClasseDAOImp();
    public void setUp() throws Exception {
        connection = connectionFactoryTest.getConnection();
        classeDAOImp = new ClasseDAOImp(connection);
    }

    public void tearDown() throws Exception {
        connection = null;
        classeDAOImp= null;
    }
    @Test
    void create() {
       Classe classe= classeDAOImp.create(new Classe(LocalTime.now(),LocalTime.now(),"new Class"));
        if (classe != null)
            assertTrue(true );
        else
            assertTrue(false );
    }

    @Test
    void find() {
        Optional<Classe> acualClasse = classeDAOImp.find(3);
        assertTrue(acualClasse.isPresent());
    }

    @Test
    void findAll() {
        List<Classe> classes =  classeDAOImp.findAll();
        int acualClasseSize = classes.size();
        int expectedClasseSize = 8;
        assertEquals(expectedClasseSize , acualClasseSize);
    }

    @Test
    void update() {
        ClasseDAOImp classeDAOImp = new ClasseDAOImp();
        Classe expectedClasse =classeDAOImp.update(new Classe(11,LocalTime.now(),LocalTime.now(),"newjj Class"));
        if (expectedClasse != null)
            assertTrue(true );
        else
            assertTrue(false );
    }

    @Test
    void delete() {
        ClasseDAOImp classeDAOImp = new ClasseDAOImp();
        Boolean actualStatusClasseDIo = classeDAOImp.delete(1);
        assertTrue(actualStatusClasseDIo);
    }
}