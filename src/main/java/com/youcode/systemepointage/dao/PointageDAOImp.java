package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Pointage;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PointageDAOImp implements GenericDAO<Pointage, Integer> {
    private final String TABLE_NAME = "Pointage";
    private final GenericDAO<Utilisateur, Integer> utilisateurDAO = new UtilisateurDAOImp();

    @Override
    public Pointage create(Pointage pointage) {
        String sql = "INSERT INTO \"" + TABLE_NAME + "\" (\"dateEtHeure\", \"utilisateurId\")" +
                " VALUES (?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setTimestamp(1, Timestamp.valueOf(pointage.getDateEtHeure()));
            preparedStatement.setInt(2, pointage.getUtilisateur().getId());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                pointage.setId(generatedKeys.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pointage;
    }

    @Override
    public Optional<Pointage> find(Integer id) {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Pointage pointage = new Pointage();
                    pointage.setId(resultSet.getInt("id"));
                    pointage.setDateEtHeure(LocalDateTime.of(
                            resultSet.getDate("dateEtHeure").toLocalDate(),
                            resultSet.getTime("DateEtHeure").toLocalTime())
                    );
                    pointage.setUtilisateur(utilisateurDAO.find(resultSet.getInt("utilisateurId")).orElse(null));
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
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\"";
        List<Pointage> pointages = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pointage pointage = new Pointage();
                pointage.setId(resultSet.getInt("id"));
                pointage.setDateEtHeure(resultSet.getTimestamp("dateEtHeure").toLocalDateTime());

                pointage.setUtilisateur(utilisateurDAO.find(resultSet.getInt("utilisateurId")).get());

                pointages.add(pointage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pointages;
    }

    @Override
    public Pointage update(Pointage pointage) {
        String sql = "UPDATE \"" + TABLE_NAME + "\" SET \"dateEtHeure\" = ?, \"utilisateurId\" = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDate(1, Date.valueOf(pointage.getDateEtHeure().toLocalDate()));
            preparedStatement.setInt(2, pointage.getUtilisateur().getId());
            preparedStatement.setInt(3, pointage.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pointage;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM \"" + TABLE_NAME + "\" WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
