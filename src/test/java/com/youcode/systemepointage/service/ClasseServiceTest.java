package com.youcode.systemepointage.service;

import com.youcode.systemepointage.model.Classe;
import com.youcode.systemepointage.model.Promotion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClasseServiceTest {
    private ClasseService classeService = new ClasseService();

    @Test
    void create() {
        Classe classe =classeService.create(new Classe(11,LocalTime.now(),LocalTime.now(),"newjj Class"));
        if (classe != null)
            assertTrue(true );
        else
            assertTrue(false );
    }

    @Test
    void find() {
        Optional<Classe> classe = classeService.find(7);
        assertTrue(classe.isPresent());
    }

    @Test
    void findAll() {
        List<Classe> classes = (List<Classe>) classeService.findAll();
        int acualClasseSize = classes.size();
        int expectedClasseSize = 14;
        assertEquals(expectedClasseSize , acualClasseSize);
    }

    @Test
    void update() {
        Classe classe = classeService.update(new Classe(11, LocalTime.now(),LocalTime.now(),"newjj Class"));
        if (classe != null)
            assertTrue(true );
        else
            assertTrue(false );
    }

    @Test
    void delete() {
        Boolean classe = classeService.delete(6);
        assertTrue(classe);
    }
}