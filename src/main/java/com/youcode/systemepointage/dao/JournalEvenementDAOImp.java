package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.JournalEvenement;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class JournalEvenementDAOImp implements GenericDAO<JournalEvenement, Integer>  {
    private String tableName = "JournalEvenement";
    @Override
    public JournalEvenement create(JournalEvenement journalEvenement) {
        String sql = "INSERT INTO \"" + tableName + "\" (\"ajouter\")" +
                " VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

           // preparedStatement.setDate(1, Date.valueOf(journalEvenement.getAjoute().toLocalDate()));


            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return journalEvenement;
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
        String sql = "UPDATE " + tableName + " SET modification  = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

           // preparedStatement.setDate(1, Date.valueOf(journalEvenement.getModification().toLocalDate()));
            // preparedStatement.setInt();

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return journalEvenement;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
