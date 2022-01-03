package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.*;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JournalEvenementDAOImp implements GenericDAO<JournalEvenement, Integer>  {
    private final String TABLE_NAME = "JournalEvenement";
    private final GenericDAO<Utilisateur, Integer> utilisateurDAO = new UtilisateurDAOImp();
    private final GenericDAO<Evenement, Integer> evenementDAO = new EvenementDAOImp();
    @Override
    public JournalEvenement create(JournalEvenement journalEvenement) {
        String sql = "INSERT INTO \"" + TABLE_NAME  + "\" (\"ajouter\", \"utilisateurId\", \"evenementId\")" +
                " VALUES (?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setTimestamp(1, Timestamp.valueOf(journalEvenement.getAjoute()));
            preparedStatement.setInt(2, journalEvenement.getUtilisateur().getId());
            preparedStatement.setInt(3, journalEvenement.getEvenement().getId());


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
//                    journalEvenement.setAjoute(LocalDateTime.of(
//                            resultSet.getDate("ajouter").toLocalDate(),
//                            resultSet.getTime("ajouter").toLocalTime())
//                    );
//                    journalEvenement.setModification(LocalDateTime.of(
//                            resultSet.getDate("modification").toLocalDate(),
//                            resultSet.getTime("modification").toLocalTime())
//                    );
//                    journalEvenement.setSuppression(LocalDateTime.of(
//                            resultSet.getDate("suppression").toLocalDate(),
//                            resultSet.getTime("suppression").toLocalTime()
//                    ));
                    journalEvenement.setAjoute(resultSet.getTimestamp("ajouter").toLocalDateTime());
                    journalEvenement.setModification(resultSet.getTimestamp("modification").toLocalDateTime());
                    journalEvenement.setSuppression(resultSet.getTimestamp("suppression").toLocalDateTime());
                    journalEvenement.setUtilisateur(utilisateurDAO.find(resultSet.getInt("utilisateurId")).orElse(null));
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
//                journalEvenement.setAjoute(LocalDateTime.of(
//                        resultSet.getDate("ajouter").toLocalDate(),
//                        resultSet.getTime("ajouter").toLocalTime())
//                );
//                journalEvenement.setModification(LocalDateTime.of(
//                        resultSet.getDate("modification").toLocalDate(),
//                        resultSet.getTime("modification").toLocalTime())
//                );
//                journalEvenement.setSuppression(LocalDateTime.of(
//                        resultSet.getDate("suppression").toLocalDate(),
//                        resultSet.getTime("suppression").toLocalTime()
//                ));
                journalEvenement.setAjoute(resultSet.getTimestamp("ajouter").toLocalDateTime());
                journalEvenement.setModification(resultSet.getTimestamp("modification").toLocalDateTime());
                journalEvenement.setSuppression(resultSet.getTimestamp("suppression").toLocalDateTime());
                journalEvenement.setUtilisateur(utilisateurDAO.find(resultSet.getInt("utilisateurId")).orElse(null));
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
        String sql = "UPDATE \"" + TABLE_NAME + "\" SET modification  = ?, utilisateurId = ?, evenementId = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setTimestamp(1, Timestamp.valueOf(journalEvenement.getModification()));
            preparedStatement.setInt(2, journalEvenement.getUtilisateur().getId());
            preparedStatement.setInt(3, journalEvenement.getEvenement().getId());
            preparedStatement.setInt(4, journalEvenement.getId());

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