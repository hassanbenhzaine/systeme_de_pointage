package com.youcode.systemepointage.dao;


import com.youcode.systemepointage.model.ChefFabrique;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChefFabriqueDAOImpl implements GenericDAO<ChefFabrique, Integer> {
    private final String tableName = "ChefFabrique";

    @Override
    public ChefFabrique create(ChefFabrique chefFabrique) {
        String sql = "INSERT INTO \"" + tableName +
                "\" (\"email\", \"motDePasse\", \"nom\", \"prenom\", \"telephone\", \"statut\", \"roleId\"," +
                " \"entreeFabrique\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, chefFabrique.getEmail());
            preparedStatement.setString(2, chefFabrique.getMotDePasse());
            preparedStatement.setString(3, chefFabrique.getNom());
            preparedStatement.setString(4, chefFabrique.getPrenom());
            preparedStatement.setString(5, chefFabrique.getTelephone());
            preparedStatement.setBoolean(6, chefFabrique.getStatut());
            preparedStatement.setInt(7, chefFabrique.getRole().getId());
            preparedStatement.setDate(8, Date.valueOf(chefFabrique.getEntreeFabrique()));

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                chefFabrique.setId(generatedKeys.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return chefFabrique;
    }

    @Override
    public Optional<ChefFabrique> find(Integer id) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ChefFabrique chefFabrique = new ChefFabrique();
                    chefFabrique.setEmail(resultSet.getString("email"));
                    chefFabrique.setMotDePasse(resultSet.getString("motDePasse"));
                    chefFabrique.setNom(resultSet.getString("nom"));
                    chefFabrique.setPrenom(resultSet.getString("prenom"));
                    chefFabrique.setTelephone(resultSet.getString("telephone"));
                    chefFabrique.setId(resultSet.getInt("id"));
                    chefFabrique.setStatut(resultSet.getBoolean("statut"));

                    return Optional.of(chefFabrique);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<ChefFabrique> findAll() {
        String sql = "SELECT * FROM " + tableName;
        List<ChefFabrique> chefFabriques = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ChefFabrique chefFabrique = new ChefFabrique();
                chefFabrique.setEmail(resultSet.getString("email"));
                chefFabrique.setMotDePasse(resultSet.getString("motDePasse"));
                chefFabrique.setNom(resultSet.getString("nom"));
                chefFabrique.setPrenom(resultSet.getString("prenom"));
                chefFabrique.setTelephone(resultSet.getString("telephone"));
                chefFabrique.setStatut(resultSet.getBoolean("statut"));
                chefFabrique.setId(resultSet.getInt("id"));

                chefFabriques.add(chefFabrique);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chefFabriques;
    }

    @Override
    public ChefFabrique update(ChefFabrique chefFabrique) {
        String sql = "UPDATE \"" + tableName + "\" SET nom = ?, prenom = ?, email = ?, motDePasse = ?" +
                ", telephone = ?, roleId = ?, active = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, chefFabrique.getNom());
            preparedStatement.setString(2, chefFabrique.getPrenom());
            preparedStatement.setString(3, chefFabrique.getEmail());
            preparedStatement.setString(4, chefFabrique.getMotDePasse());
            preparedStatement.setString(5, chefFabrique.getTelephone());
            preparedStatement.setInt(6, chefFabrique.getRole().getId());
            preparedStatement.setBoolean(7, chefFabrique.getStatut());
            preparedStatement.setInt(8, chefFabrique.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chefFabrique;
    }


    public boolean delete(Integer id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";

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

