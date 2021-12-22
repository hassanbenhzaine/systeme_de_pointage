package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.*;
import com.youcode.systemepointage.model.Formateur;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FormateurDAOImp implements GenericDAO<Formateur, Integer> {
    private final String tableName = "Formateur";
    private final GenericDAO<Role, Integer> roleDAO = new RoleDAOImp();
    private final GenericDAO<Specialite, Integer> specialiteDAO = new SpecialiteDAOImp();
    private final GenericDAO<Classe, Integer> classeDAO = new ClasseDAOImp();

    @Override
    public Formateur create(Formateur formateur) {
        String sql = "INSERT INTO \"" + tableName +
                "\" (\"email\", \"motDePasse\", \"nom\", \"prenom\", \"telephone\", \"statut\", \"roleId\"" +
                ", \"specialiteId\", \"classeId\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, formateur.getEmail());
            preparedStatement.setString(2, formateur.getMotDePasse());
            preparedStatement.setString(3, formateur.getNom());
            preparedStatement.setString(4, formateur.getPrenom());
            preparedStatement.setString(5, formateur.getTelephone());
            preparedStatement.setBoolean(6, formateur.getStatut());
            preparedStatement.setInt(7, formateur.getRole().getId());
            preparedStatement.setInt(8, formateur.getSpecialite().getId());
            preparedStatement.setInt(9, formateur.getClasse().getId());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                formateur.setId(generatedKeys.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return formateur;
    }

    @Override
    public Optional<Formateur> find(Integer id) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Formateur formateur = new Formateur();
                    formateur.setEmail(resultSet.getString("email"));
                    formateur.setMotDePasse(resultSet.getString("motDePasse"));
                    formateur.setNom(resultSet.getString("nom"));
                    formateur.setPrenom(resultSet.getString("prenom"));
                    formateur.setTelephone(resultSet.getString("telephone"));
                    formateur.setStatut(resultSet.getBoolean("statut"));
                    formateur.setId(resultSet.getInt("id"));
                    formateur.setRole(roleDAO.find(resultSet.getInt("roleId")).get());
                    formateur.setSpecialite(specialiteDAO.find(resultSet.getInt("specialiteId")).get());
                    formateur.setClasse(classeDAO.find(resultSet.getInt("classeId")).get());

                    return Optional.of(formateur);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Formateur> findAll() {
        String sql = "SELECT * FROM " + tableName;
        List<Formateur> chefFabriques = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Formateur formateur = new Formateur();
                formateur.setEmail(resultSet.getString("email"));
                formateur.setMotDePasse(resultSet.getString("motDePasse"));
                formateur.setNom(resultSet.getString("nom"));
                formateur.setPrenom(resultSet.getString("prenom"));
                formateur.setTelephone(resultSet.getString("telephone"));
                formateur.setStatut(resultSet.getBoolean("statut"));
                formateur.setId(resultSet.getInt("id"));
                formateur.setRole(roleDAO.find(resultSet.getInt("roleId")).get());
                formateur.setSpecialite(specialiteDAO.find(resultSet.getInt("specialiteId")).get());
                formateur.setClasse(classeDAO.find(resultSet.getInt("classeId")).get());

                chefFabriques.add(formateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chefFabriques;
    }

    @Override
    public Formateur update(Formateur formateur) {
        String sql = "UPDATE \"" + tableName + "\" SET nom = ?, prenom = ?, email = ?, motDePasse = ?" +
                ", telephone = ?, status = ?, roleId = ?, specialiteId = ?, classeId = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, formateur.getNom());
            preparedStatement.setString(2, formateur.getPrenom());
            preparedStatement.setString(3, formateur.getEmail());
            preparedStatement.setString(4, formateur.getMotDePasse());
            preparedStatement.setString(5, formateur.getTelephone());
            preparedStatement.setInt(6, formateur.getRole().getId());
            preparedStatement.setBoolean(7, formateur.getStatut());
            preparedStatement.setInt(8, formateur.getRole().getId());
            preparedStatement.setInt(9, formateur.getSpecialite().getId());
            preparedStatement.setInt(10, formateur.getClasse().getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formateur;
    }


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
