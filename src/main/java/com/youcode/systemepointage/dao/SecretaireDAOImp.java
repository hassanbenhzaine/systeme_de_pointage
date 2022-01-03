package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Secretaire;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SecretaireDAOImp implements GenericDAO<Secretaire, Integer> {
    private final String TABLE_NAME = "Secretaire";
    private final GenericDAO<Role, Integer> roleDAO = new RoleDAOImp();

    @Override
    public Secretaire create(Secretaire secretaire) {
        String sql = "INSERT INTO \"" + TABLE_NAME +
                "\" (email, \"motDePasse\", nom, prenom, telephone, statut, \"roleId\", sexe)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, secretaire.getEmail());
            preparedStatement.setString(2, secretaire.getMotDePasse());
            preparedStatement.setString(3, secretaire.getNom());
            preparedStatement.setString(4, secretaire.getPrenom());
            preparedStatement.setString(5, secretaire.getTelephone());
            preparedStatement.setBoolean(6, secretaire.getStatut());
            preparedStatement.setInt(7, secretaire.getRole().getId());
            preparedStatement.setString(8, String.valueOf(secretaire.getSexe()));

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                secretaire.setId(generatedKeys.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return secretaire;
    }

    @Override
    public Optional<Secretaire> find(Integer id) {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Secretaire secretaire = new Secretaire();
                    secretaire.setEmail(resultSet.getString("email"));
                    secretaire.setMotDePasse(resultSet.getString("motDePasse"));
                    secretaire.setNom(resultSet.getString("nom"));
                    secretaire.setPrenom(resultSet.getString("prenom"));
                    secretaire.setTelephone(resultSet.getString("telephone"));
                    secretaire.setStatut(resultSet.getBoolean("statut"));
                    secretaire.setSexe(resultSet.getString("sexe").charAt(0));
                    secretaire.setId(resultSet.getInt("id"));
                    secretaire.setRole(roleDAO.find(resultSet.getInt("roleId")).get());

                    return Optional.of(secretaire);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Secretaire> findAll() {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\"";
        List<Secretaire> chefFabriques = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Secretaire secretaire = new Secretaire();
                secretaire.setEmail(resultSet.getString("email"));
                secretaire.setMotDePasse(resultSet.getString("motDePasse"));
                secretaire.setNom(resultSet.getString("nom"));
                secretaire.setPrenom(resultSet.getString("prenom"));
                secretaire.setTelephone(resultSet.getString("telephone"));
                secretaire.setStatut(resultSet.getBoolean("statut"));
                secretaire.setSexe(resultSet.getString("sexe").charAt(0));
                secretaire.setId(resultSet.getInt("id"));
                secretaire.setRole(roleDAO.find(resultSet.getInt("roleId")).get());

                chefFabriques.add(secretaire);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chefFabriques;
    }

    @Override
    public Secretaire update(Secretaire secretaire) {
        String sql = "UPDATE \"" + TABLE_NAME + "\" SET nom = ?, prenom = ?, email = ?, \"motDePasse\" = ?" +
                ", telephone = ?, \"roleId\" = ?, statut = ?, sexe = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, secretaire.getNom());
            preparedStatement.setString(2, secretaire.getPrenom());
            preparedStatement.setString(3, secretaire.getEmail());
            preparedStatement.setString(4, secretaire.getMotDePasse());
            preparedStatement.setString(5, secretaire.getTelephone());
            preparedStatement.setInt(6, secretaire.getRole().getId());
            preparedStatement.setBoolean(7, secretaire.getStatut());
            preparedStatement.setString(8, String.valueOf(secretaire.getSexe()));
            preparedStatement.setInt(9, secretaire.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return secretaire;
    }


    public boolean delete(Integer id) {
        String sql = "DELETE FROM \"" + TABLE_NAME + "\" WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
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
