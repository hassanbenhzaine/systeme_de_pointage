package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.ConnectionFactory;
import com.youcode.systemepointage.DAO;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UtilisateurDAO implements DAO<Utilisateur> {
    private final String tableName = "Utilisateur";

    @Override
    public List<Utilisateur> findAll() {
        String sql = "SELECT * FROM " + tableName;

        List<Utilisateur> chefFabriques = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

//            while (resultSet.next()) {
//                Utilisateur chefFabrique = new Utilisateur();
//                chefFabrique.setId(resultSet.getInt("CheffabriqueID"));
//                chefFabrique.setNom(resultSet.getString("Nom"));
//                chefFabrique.setPrenom(resultSet.getString("Prenom"));
//                chefFabrique.setEmail(resultSet.getString("Email"));
//                chefFabrique.setMotDePasse(resultSet.getString("MotDePasse"));
//                chefFabrique.setTelephone(resultSet.getInt("Telephone"));
//                chefFabrique.setEntreeFabrique(resultSet.getDate("EntreeFabrique"));
//
//                chefFabriques.add(chefFabrique);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chefFabriques;
    }

    @Override
    public boolean create(Utilisateur utilisateur) {
        String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, utilisateur.getEmail());
            preparedStatement.setString(2, utilisateur.getMotDePasse());
            preparedStatement.setString(3, utilisateur.getNom());
            preparedStatement.setString(4, utilisateur.getPrenom());
            preparedStatement.setInt(5, utilisateur.getTelephone());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Optional<Utilisateur> find(int id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                Utilisateur chefFabrique = new Utilisateur();
//                chefFabrique.setId(resultSet.getInt("CheffabriqueID"));
//                chefFabrique.setNom(resultSet.getString("Nom"));
//                chefFabrique.setPrenom(resultSet.getString("Prenom"));
//                chefFabrique.setEmail(resultSet.getString("Email"));
//                chefFabrique.setMotDePasse(resultSet.getString("MotDePasse"));
//                chefFabrique.setTelephone(resultSet.getInt("Telephone"));
//                chefFabrique.setEntreeFabrique(resultSet.getDate("EntreeFabrique"));
//
//                return Optional.of(chefFabrique);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void update(Utilisateur chefFabrique) {
        String sql = "UPDATE " + tableName + " SET Nom = ?, Prenom = ?, Email = ?, MotDePasse = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, chefFabrique.getNom());
            preparedStatement.setString(2, chefFabrique.getPrenom());
            preparedStatement.setString(3, chefFabrique.getEmail());
            preparedStatement.setString(4, chefFabrique.getMotDePasse());
            preparedStatement.setInt(5, chefFabrique.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Utilisateur chefFabrique) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, chefFabrique.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

