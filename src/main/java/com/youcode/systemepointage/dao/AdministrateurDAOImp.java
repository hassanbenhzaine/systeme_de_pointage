package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Administrateur;
import com.youcode.systemepointage.model.Role;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministrateurDAOImp implements GenericDAO<Administrateur, Integer> {
    private final String TABLE_NAME = "Administrateur";
    private final GenericDAO<Role, Integer> roleDAO = new RoleDAOImp();

    @Override
    public Administrateur create(Administrateur administrateur) {
        String sql = "INSERT INTO \"" + TABLE_NAME +
                "\" (\"email\", \"motDePasse\", \"nom\", \"prenom\", \"telephone\", \"statut\", \"roleId\")" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, administrateur.getEmail());
            preparedStatement.setString(2, administrateur.getMotDePasse());
            preparedStatement.setString(3, administrateur.getNom());
            preparedStatement.setString(4, administrateur.getPrenom());
            preparedStatement.setString(5, administrateur.getTelephone());
            preparedStatement.setBoolean(6, administrateur.getStatut());
            preparedStatement.setInt(7, administrateur.getRole().getId());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                administrateur.setId(generatedKeys.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return administrateur;
    }

    @Override
    public Optional<Administrateur> find(Integer id) {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Administrateur administrateur = new Administrateur();
                    administrateur.setEmail(resultSet.getString("email"));
                    administrateur.setMotDePasse(resultSet.getString("motDePasse"));
                    administrateur.setNom(resultSet.getString("nom"));
                    administrateur.setPrenom(resultSet.getString("prenom"));
                    administrateur.setTelephone(resultSet.getString("telephone"));
                    administrateur.setStatut(resultSet.getBoolean("statut"));
                    administrateur.setId(resultSet.getInt("id"));
                    administrateur.setRole(roleDAO.find(resultSet.getInt("roleId")).get());

                    return Optional.of(administrateur);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Administrateur> findAll() {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\"";
        List<Administrateur> chefFabriques = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Administrateur administrateur = new Administrateur();
                administrateur.setEmail(resultSet.getString("email"));
                administrateur.setMotDePasse(resultSet.getString("motDePasse"));
                administrateur.setNom(resultSet.getString("nom"));
                administrateur.setPrenom(resultSet.getString("prenom"));
                administrateur.setTelephone(resultSet.getString("telephone"));
                administrateur.setStatut(resultSet.getBoolean("statut"));
                administrateur.setId(resultSet.getInt("id"));
                administrateur.setRole(roleDAO.find(resultSet.getInt("roleId")).get());

                chefFabriques.add(administrateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chefFabriques;
    }

    @Override
    public Administrateur update(Administrateur administrateur) {
        String sql = "UPDATE \"" + TABLE_NAME + "\" SET nom = ?, prenom = ?, email = ?, motDePasse = ?" +
                ", telephone = ?, roleId = ?, active = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, administrateur.getNom());
            preparedStatement.setString(2, administrateur.getPrenom());
            preparedStatement.setString(3, administrateur.getEmail());
            preparedStatement.setString(4, administrateur.getMotDePasse());
            preparedStatement.setString(5, administrateur.getTelephone());
            preparedStatement.setInt(6, administrateur.getRole().getId());
            preparedStatement.setBoolean(7, administrateur.getStatut());
            preparedStatement.setInt(8, administrateur.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administrateur;
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
