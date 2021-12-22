package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.JournalEvenement;

import java.util.List;
import java.util.Optional;

public class JournalEvenementDAOImp implements GenericDAO<JournalEvenement, Integer> {
    private final String tableName = "JournalEvenement";

    @Override
    public JournalEvenement create(JournalEvenement journalEvenement) {
        return null;
    }

    @Override
    public Optional<JournalEvenement> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<JournalEvenement> findAll() {
        return null;
    }

    @Override
    public JournalEvenement update(JournalEvenement journalEvenement) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
