package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.*;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JournalEvenementDAOImp implements GenericDAO<JournalEvenement, Integer>  {
    private final String TABLE_NAME = "JournalEvenement";
    private final GenericDAO<Secretaire, Integer> secretaireDAO = new SecretaireDAOImp();
    private final GenericDAO<Evenement, Integer> evenementDAO = new EvenementDAOImp();
    @Override
    public JournalEvenement create(JournalEvenement journalEvenement) {
        String sql = "INSERT INTO \"" + TABLE_NAME  + "\" (\"debut\", \"fin\", \"nom\", \"secretaireId\", \"evenementId\")" +
                " VALUES (?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDate(1, Date.valueOf(journalEvenement.getDebut().toLocalDate()));
            preparedStatement.setDate(2, Date.valueOf(journalEvenement.getFin().toLocalDate()));
            preparedStatement.setString(3, journalEvenement.getNom());
            preparedStatement.setInt(4, journalEvenement.getSecretaire().getId());
            preparedStatement.setInt(5, journalEvenement.getEvenement().getId());


            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return journalEvenement;
    }

    @Override
    public Optional<JournalEvenement> find(Integer id) {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE \"id\" = ?";


        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    JournalEvenement journalEvenement = new JournalEvenement();
                    journalEvenement.setId(resultSet.getInt("id"));
                    journalEvenement.setDebut(LocalDateTime.of(
                            resultSet.getDate("debut").toLocalDate(),
                            resultSet.getTime("debut").toLocalTime())
                    );
                    journalEvenement.setFin(LocalDateTime.of(
                            resultSet.getDate("fin").toLocalDate(),
                            resultSet.getTime("fin").toLocalTime())
                    );
                    journalEvenement.setNom(resultSet.getString("nom"));
                    journalEvenement.setSecretaire(secretaireDAO.find(resultSet.getInt("secretaireId")).orElse(null));
                    journalEvenement.setEvenement(evenementDAO.find(resultSet.getInt("evenementId")).orElse(null));
                    return Optional.of(journalEvenement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<JournalEvenement> findAll() {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\"";
        List<JournalEvenement> journalEvenements = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                JournalEvenement journalEvenement = new JournalEvenement();
                journalEvenement.setId(resultSet.getInt("id"));
                journalEvenement.setDebut(LocalDateTime.of(
                        resultSet.getDate("debut").toLocalDate(),
                        resultSet.getTime("debut").toLocalTime())
                );
                journalEvenement.setFin(LocalDateTime.of(
                        resultSet.getDate("fin").toLocalDate(),
                        resultSet.getTime("fin").toLocalTime())
                );
                journalEvenement.setNom(resultSet.getString("nom"));
                journalEvenement.setSecretaire(secretaireDAO.find(resultSet.getInt("secretaireId")).orElse(null));
                journalEvenement.setEvenement(evenementDAO.find(resultSet.getInt("evenementId")).orElse(null));
                journalEvenements.add(journalEvenement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return journalEvenements;
    }

    @Override
    public JournalEvenement update(JournalEvenement journalEvenement) {
        String sql = "UPDATE \"" + TABLE_NAME + "\" SET debut  = ?, fin = ?, nom = ?, secretairerId = ?, evenementId = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDate(1, Date.valueOf(journalEvenement.getDebut().toLocalDate()));
            preparedStatement.setDate(2, Date.valueOf(journalEvenement.getFin().toLocalDate()));
            preparedStatement.setString(3, journalEvenement.getNom());
            preparedStatement.setInt(4, journalEvenement.getSecretaire().getId());
            preparedStatement.setInt(5, journalEvenement.getEvenement().getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return journalEvenement;
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
// test