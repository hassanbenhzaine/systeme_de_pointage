package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.shared.ConnectionFactory;

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
                "\" (\"email\", \"motDePasse\", \"nom\", \"prenom\", \"telephone\", \"statut\")" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(sql);

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, utilisateur.getEmail());
            preparedStatement.setString(2, utilisateur.getMotDePasse());
            preparedStatement.setString(3, utilisateur.getNom());
            preparedStatement.setString(4, utilisateur.getPrenom());
            preparedStatement.setString(5, utilisateur.getTelephone());
            preparedStatement.setBoolean(6, utilisateur.getStatut());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                utilisateur.setId(generatedKeys.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
    public Optional<Utilisateur> find(Integer id) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setEmail(resultSet.getString("email"));
                    utilisateur.setMotDePasse(resultSet.getString("motDePasse"));
                    utilisateur.setNom(resultSet.getString("nom"));
                    utilisateur.setPrenom(resultSet.getString("prenom"));
                    utilisateur.setTelephone(resultSet.getString("telephone"));
                    utilisateur.setId(resultSet.getInt("id"));

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
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setMotDePasse(resultSet.getString("motDePasse"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setTelephone(resultSet.getString("telephone"));
                utilisateur.setId(resultSet.getInt("id"));

                chefFabriques.add(utilisateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chefFabriques;
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        String sql = "UPDATE \"" + tableName + "\" SET nom = ?, prenom = ?, email = ?, motDePasse = ?" +
                ", telephone = ?, roleId = ?, active = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getEmail());
            preparedStatement.setString(4, utilisateur.getMotDePasse());
            preparedStatement.setString(5, utilisateur.getTelephone());
            preparedStatement.setInt(6, utilisateur.getRole().getId());
            preparedStatement.setBoolean(7, utilisateur.getStatut());
            preparedStatement.setInt(8, utilisateur.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
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

    @Override
    public Optional<Utilisateur> findByEmailAndPassword(String email, String motDePasse) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"email\" = ? AND \"motDePasse\" = ?";
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, motDePasse);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setEmail(resultSet.getString("email"));
                    utilisateur.setMotDePasse(resultSet.getString("motDePasse"));
                    utilisateur.setNom(resultSet.getString("nom"));
                    utilisateur.setPrenom(resultSet.getString("prenom"));
                    utilisateur.setTelephone(resultSet.getString("telephone"));
                    utilisateur.setId(resultSet.getInt("id"));

                    return Optional.of(utilisateur);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Utilisateur> findByEmail(String email) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"email\" = ?";
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setEmail(resultSet.getString("email"));
                    utilisateur.setMotDePasse(resultSet.getString("motDePasse"));
                    utilisateur.setNom(resultSet.getString("nom"));
                    utilisateur.setPrenom(resultSet.getString("prenom"));
                    utilisateur.setTelephone(resultSet.getString("telephone"));
                    utilisateur.setId(resultSet.getInt("id"));

                    return Optional.of(utilisateur);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

