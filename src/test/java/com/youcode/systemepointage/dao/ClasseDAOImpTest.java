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
    private ClasseDAOImp classeDAOImp;
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
        ClasseDAOImp classeDAOImp = new ClasseDAOImp();
        classeDAOImp.create(new Classe(LocalTime.now(),LocalTime.now(),"new Class"));
        List<Classe> classes = classeDAOImp.findAll();
        int acualClasseSize = classes.size();
        int expectedClasseSize = 9;
        assertEquals(expectedClasseSize , acualClasseSize);
    }

    @Test
    void find() {
        ClasseDAOImp classeDAOImp = new ClasseDAOImp();
        Boolean expectedClasseSize = true;
        Optional<Classe> acualClasse = classeDAOImp.find(3);
        System.out.println(acualClasse);
        assertEquals(expectedClasseSize , acualClasse.isPresent());
    }

    @Test
    void findAll() {
        ClasseDAOImp classeDAOImp = new ClasseDAOImp();
        List<Classe> classes =  classeDAOImp.findAll();
        int acualClasseSize = classes.size();
        int expectedClasseSize = 8;
        assertEquals(expectedClasseSize , acualClasseSize);
    }

    @Test
    void update() {
        ClasseDAOImp classeDAOImp = new ClasseDAOImp();
        Classe expectedClasse = new Classe(11,LocalTime.now(),LocalTime.now(),"newjj Class");
        Classe actualStatusClasseDto = classeDAOImp.update(expectedClasse);
        assertEquals(actualStatusClasseDto , expectedClasse);
    }

    @Test
    void delete() {
        ClasseDAOImp classeDAOImp = new ClasseDAOImp();
        Boolean actualStatusClasseDIo = classeDAOImp.delete(1);
        Boolean exectedUPdateStatusClasseDIo = true ;
        assertEquals(actualStatusClasseDIo , exectedUPdateStatusClasseDIo);
    }
}