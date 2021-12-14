package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.shared.ConnectionFactory;
import com.youcode.systemepointage.model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UtilisateurDAOImp implements UtilisateurDAO {
    private final String tableName = "Utilisateur";


    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        String sql = "INSERT INTO \"" + tableName +
                "\" (\"Email\", \"MotDePasse\", \"Nom\", \"Prenom\", \"Telephone\")" +
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, utilisateur.getEmail());
            preparedStatement.setString(2, utilisateur.getMotDePasse());
            preparedStatement.setString(3, utilisateur.getNom());
            preparedStatement.setString(4, utilisateur.getPrenom());
            preparedStatement.setString(5, utilisateur.getTelephone());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
    public Optional<Utilisateur> find(int id) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"UtilisateurID\" = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setEmail(resultSet.getString("Email"));
                    utilisateur.setMotDePasse(resultSet.getString("MotDePasse"));
                    utilisateur.setNom(resultSet.getString("Nom"));
                    utilisateur.setPrenom(resultSet.getString("Prenom"));
                    utilisateur.setTelephone(resultSet.getString("Telephone"));
                    utilisateur.setId(resultSet.getInt("UtilisateurID"));

                    return Optional.of(utilisateur);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Utilisateur> findAll() {
        String sql = "SELECT * FROM " + tableName;
        List<Utilisateur> chefFabriques = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setEmail(resultSet.getString("Email"));
                utilisateur.setMotDePasse(resultSet.getString("MotDePasse"));
                utilisateur.setNom(resultSet.getString("Nom"));
                utilisateur.setPrenom(resultSet.getString("Prenom"));
                utilisateur.setTelephone(resultSet.getString("Telephone"));
                utilisateur.setId(resultSet.getInt("UtilisateurID"));

                chefFabriques.add(utilisateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chefFabriques;
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        String sql = "UPDATE " + tableName + " SET Nom = ?, Prenom = ?, Email = ?, MotDePasse = ?, Telephone = ? WHERE UtilisateurID = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getEmail());
            preparedStatement.setString(4, utilisateur.getMotDePasse());
            preparedStatement.setString(5, utilisateur.getTelephone());
            preparedStatement.setInt(6, utilisateur.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
    public Utilisateur delete(Utilisateur utilisateur) {
        String sql = "DELETE FROM " + tableName + " WHERE UtilisateurID = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, utilisateur.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
    public Optional<Utilisateur> findByEmailAndPassword(String email, String motDePasse) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"Email\" = ? AND \"MotDePasse\" = ?";
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, motDePasse);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setEmail(resultSet.getString("Email"));
                    utilisateur.setMotDePasse(resultSet.getString("MotDePasse"));
                    utilisateur.setNom(resultSet.getString("Nom"));
                    utilisateur.setPrenom(resultSet.getString("Prenom"));
                    utilisateur.setTelephone(resultSet.getString("Telephone"));
                    utilisateur.setId(resultSet.getInt("UtilisateurID"));

                    return Optional.of(utilisateur);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

