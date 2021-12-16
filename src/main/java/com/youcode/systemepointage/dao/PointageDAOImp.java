package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PointageDAOImp implements PointageDAO {
    private final String tableName = "Pointage";

    @Override
    public Pointage create(Pointage pointage) {
        String sql = "INSERT INTO \"" + tableName + " (\"dateEtHeure\", \"utilisateurID\")" +
                " VALUES (?, ?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDate(1, Date.valueOf(pointage.getDateEtHeure().toLocalDate()));
            preparedStatement.setInt(2, pointage.getUtilisateur().getId());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pointage;
    }

    @Override
    public Optional<Pointage> find(Integer id) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Pointage pointage = new Pointage();
                    pointage.setId(resultSet.getInt("id"));
                    pointage.setDateEtHeure(LocalDateTime.of(resultSet.getDate("dateEtHeure").toLocalDate(), resultSet.getTime("DateEtHeure").toLocalTime()));
                    pointage.setUtilisateur(new Utilisateur(resultSet.getInt("utilisateurId")));

                    return Optional.of(pointage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Pointage> findAll() {
        return null;
    }

    @Override
    public Pointage update(Pointage pointage) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Pointage> findAllByUser(Utilisateur utilisateur) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"utilisateurId\" = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, utilisateur.getId());

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Pointage> pointages = new ArrayList<>();
                while (resultSet.next()) {
                    Pointage pointage = new Pointage();
                    pointage.setId(resultSet.getInt("id"));
                    pointage.setDateEtHeure(LocalDateTime.of(resultSet.getDate("dateEtHeure").toLocalDate(), resultSet.getTime("DateEtHeure").toLocalTime()));
                    pointage.setUtilisateur(new Utilisateur(resultSet.getInt("utilisateurId")));

                    pointages.add(pointage);
                }
                return pointages;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
