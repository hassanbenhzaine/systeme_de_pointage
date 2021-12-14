package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.ConnectionFactory;
import com.youcode.systemepointage.DAO;
import com.youcode.systemepointage.model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class UtilisateurDAOImp implements DAO<Utilisateur> {
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
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"Id\" = ?";

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
      // findall prepared statement
        return null;
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {

        return null;
    }

    @Override
    public Utilisateur delete(Utilisateur utilisateur) {
        return null;
    }
}

