package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.ChefFabrique;
import com.youcode.systemepointage.model.Evenement;
import com.youcode.systemepointage.model.Specialite;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EvenementDAOImp implements GenericDAO<Evenement, Integer>  {
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
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Evenement evenement = new Evenement();
                    evenement.setDescription(resultSet.getString("description"));
                    evenement.setNom(resultSet.getString("nom"));
                    evenement.setProposer(resultSet.getBoolean("proposer"));
                    evenement.setId(resultSet.getInt("id"));
                    evenement.setDebut(LocalDateTime.of(resultSet.getDate("debut").toLocalDate(),
                            resultSet.getTime("debut").toLocalTime()));
                    evenement.setFin(LocalDateTime.of(resultSet.getDate("fin").toLocalDate(),
                            resultSet.getTime("fin").toLocalTime()));

                    return Optional.of(evenement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Evenement> findAll() {
        String sql = "SELECT * FROM  \"" + tableName + "\"";
        List<Evenement> evenementList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Evenement evenement = new Evenement();
                evenement.setDescription(resultSet.getString("description"));
                evenement.setNom(resultSet.getString("nom"));
                evenement.setProposer(resultSet.getBoolean("proposer"));
                evenement.setId(resultSet.getInt("id"));
                evenement.setDebut(LocalDateTime.of(resultSet.getDate("debut").toLocalDate(),
                        resultSet.getTime("debut").toLocalTime()));
                evenement.setFin(LocalDateTime.of(resultSet.getDate("fin").toLocalDate(),
                        resultSet.getTime("fin").toLocalTime()));

                evenementList.add(evenement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return evenementList;
        // return null;
    }

    @Override
    public Evenement update(Evenement evenement) {
        String sql = "UPDATE \"" + tableName + "\" SET description = ?, nom = ?, proposer = ?, debut = ?, fin = ? WHERE id = ?";
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
        String sql = "DELETE FROM \"" + tableName + "\" WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

