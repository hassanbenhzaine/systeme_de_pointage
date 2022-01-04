package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Etudiant;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EtudiantDAOImp implements GenericDAO<Etudiant, Integer> {
    private final String TABLE_NAME = "Etudiant";

    @Override
    public Etudiant create(Etudiant etudiant) {
        String sql = "INSERT INTO \"" + TABLE_NAME +
                "\" (\"email\", \"motDePasse\", \"nom\", \"prenom\", \"telephone\", \"statut\", \"roleId\"," +
                "\"promotionId\", \"specialiteId\", \"formateurId\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, etudiant.getEmail());
            preparedStatement.setString(2, etudiant.getMotDePasse());
            preparedStatement.setString(3, etudiant.getNom());
            preparedStatement.setString(4, etudiant.getPrenom());
            preparedStatement.setString(5, etudiant.getTelephone());
            preparedStatement.setBoolean(6, etudiant.getStatut());
            preparedStatement.setInt(7, etudiant.getRoleId());
            preparedStatement.setInt(8, etudiant.getPromotionId());
            preparedStatement.setInt(9, etudiant.getSpecialiteId());
            preparedStatement.setInt(10, etudiant.getFormateurId());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                etudiant.setId(generatedKeys.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return etudiant;
    }

    @Override
    public Optional<Etudiant> find(Integer id) {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setId(resultSet.getInt("id"));
                    etudiant.setEmail(resultSet.getString("email"));
                    etudiant.setMotDePasse(resultSet.getString("motDePasse"));
                    etudiant.setNom(resultSet.getString("nom"));
                    etudiant.setPrenom(resultSet.getString("prenom"));
                    etudiant.setTelephone(resultSet.getString("telephone"));
                    etudiant.setStatut(resultSet.getBoolean("statut"));
                    etudiant.setRoleId(resultSet.getInt("roleId"));
                    etudiant.setPromotionId(resultSet.getInt("promotionId"));
                    etudiant.setSpecialiteId(resultSet.getInt("specialiteId"));
                    etudiant.setFormateurId(resultSet.getInt("formateurId"));

                    return Optional.of(etudiant);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Etudiant> findAll() {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\"";
        List<Etudiant> etudiants = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setId(resultSet.getInt("id"));
                etudiant.setEmail(resultSet.getString("email"));
                etudiant.setMotDePasse(resultSet.getString("motDePasse"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setTelephone(resultSet.getString("telephone"));
                etudiant.setStatut(resultSet.getBoolean("statut"));
                etudiant.setRoleId(resultSet.getInt("roleId"));
                etudiant.setPromotionId(resultSet.getInt("promotionId"));
                etudiant.setSpecialiteId(resultSet.getInt("specialiteId"));
                etudiant.setFormateurId(resultSet.getInt("formateurId"));

                etudiants.add(etudiant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return etudiants;
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        String sql = "UPDATE \"" + TABLE_NAME + "\" SET nom = ?, prenom = ?, email = ?, motDePasse = ?" +
                ", telephone = ?, statut = ?, roleId = ?, promotionId = ?, specialiteId = ?, formateurId = ?" +
                " WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getEmail());
            preparedStatement.setString(4, etudiant.getMotDePasse());
            preparedStatement.setString(5, etudiant.getTelephone());
            preparedStatement.setBoolean(6, etudiant.getStatut());
            preparedStatement.setInt(7, etudiant.getRoleId());
            preparedStatement.setInt(8, etudiant.getFormateurId());
            preparedStatement.setInt(9, etudiant.getSpecialiteId());
            preparedStatement.setInt(10, etudiant.getFormateurId());
            preparedStatement.setInt(11, etudiant.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return etudiant;
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
