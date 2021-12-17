package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Evenement;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class EvenementDAOImp implements EvenementDAO {
    private String tableName = "Evenement";
    // description nom proposer debut fin
    @Override
    public Evenement create(Evenement evenement) {
        String sql = "INSERT INTO \"" + tableName + "\" (\"description\", \"nom\", \"proposer\", \"debut\", \"fin\")" +
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, evenement.getDescription());
            preparedStatement.setString(2, evenement.getNom());
            preparedStatement.setBoolean(3, evenement.getProposer());
            preparedStatement.setDate(4, Date.valueOf(evenement.getDebut().toLocalDate()));
            preparedStatement.setDate(5, Date.valueOf(evenement.getFin().toLocalDate()));


            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return evenement;
    }

    @Override
    public Optional<Evenement> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Evenement> findAll() {
        return null;
    }

    @Override
    public Evenement update(Evenement evenement) {
        String sql = "UPDATE " + tableName + " SET description = ?, nom = ?, proposer = ?, debut = ?, fin = ? WHERE id = ?";
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, evenement.getDescription());
            preparedStatement.setString(2, evenement.getNom());
            preparedStatement.setBoolean(3, evenement.getProposer());
            preparedStatement.setDate(4, Date.valueOf(evenement.getDebut().toLocalDate()));
            preparedStatement.setDate(5, Date.valueOf(evenement.getFin().toLocalDate()));
            preparedStatement.setInt(6, evenement.getId());


            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return evenement;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
