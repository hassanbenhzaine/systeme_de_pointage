package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UtilisateurDAOImp implements GenericDAO<Utilisateur, Integer> {
    private final String TABLE_NAME = "Utilisateur";
    private final GenericDAO<Role, Integer> roleDAO = new RoleDAOImp();

    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        String sql = "INSERT INTO \"" + TABLE_NAME +
                "\" (\"email\", \"motDePasse\", \"nom\", \"prenom\", \"telephone\", \"statut\", \"roleId\", \"sexe\")" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, utilisateur.getEmail());
            preparedStatement.setString(2, utilisateur.getMotDePasse());
            preparedStatement.setString(3, utilisateur.getNom());
            preparedStatement.setString(4, utilisateur.getPrenom());
            preparedStatement.setString(5, utilisateur.getTelephone());
            preparedStatement.setBoolean(6, utilisateur.getStatut());
            preparedStatement.setInt(7, utilisateur.getRole().getId());
            preparedStatement.setString(8, String.valueOf(utilisateur.getSexe()));
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
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getConnection();
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
                    utilisateur.setStatut(resultSet.getBoolean("statut"));
                    utilisateur.setSexe(resultSet.getString("sexe").charAt(0));
                    utilisateur.setId(resultSet.getInt("id"));
                    utilisateur.setRole(roleDAO.find(resultSet.getInt("roleId")).get());

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
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\"";
        List<Utilisateur> utilisateurs = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setMotDePasse(resultSet.getString("motDePasse"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setTelephone(resultSet.getString("telephone"));
                utilisateur.setStatut(resultSet.getBoolean("statut"));
                utilisateur.setSexe(resultSet.getString("sexe") == null ? ' ' : resultSet.getString("sexe").charAt(0));
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setRole(roleDAO.find(resultSet.getInt("roleId")).get());

                utilisateurs.add(utilisateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return utilisateurs;
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        String sql = "UPDATE \"" + TABLE_NAME + "\" SET nom = ?, prenom = ?, email = ?, \"motDePasse\" = ?" +
                ", telephone = ?, \"roleId\" = ?, statut = ?, sexe = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getEmail());
            preparedStatement.setString(4, utilisateur.getMotDePasse());
            preparedStatement.setString(5, utilisateur.getTelephone());
            preparedStatement.setInt(6, utilisateur.getRole().getId());
            preparedStatement.setBoolean(7, utilisateur.getStatut());
            preparedStatement.setString(8, Character.toString(utilisateur.getSexe()));
            preparedStatement.setInt(9, utilisateur.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateur;
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

