package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.*;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EtudiantDAOImp implements GenericDAO<Etudiant, Integer> {
    private final String tableName = "Etudiant";
    private final GenericDAO<Role, Integer> roleDAO = new RoleDAOImp();
    private final GenericDAO<Promotion, Integer> promotionDAO = new PromotionDAOImp();
    private final GenericDAO<Classe, Integer> classeDAO = new ClasseDAOImp();
    private final GenericDAO<Specialite, Integer> specialiteDAO = new SpecialiteDAOImp();
    private final GenericDAO<Formateur, Integer> formateurDAO = new FormateurDAOImp();

    @Override
    public Etudiant create(Etudiant etudiant) {
        String sql = "INSERT INTO \"" + tableName +
                "\" (\"email\", \"motDePasse\", \"nom\", \"prenom\", \"telephone\", \"statut\", \"roleId\"," +
                "\"promotionId\", \"specialiteId\", \"formateurId\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, etudiant.getEmail());
            preparedStatement.setString(2, etudiant.getMotDePasse());
            preparedStatement.setString(3, etudiant.getNom());
            preparedStatement.setString(4, etudiant.getPrenom());
            preparedStatement.setString(5, etudiant.getTelephone());
            preparedStatement.setBoolean(6, etudiant.getStatut());
            preparedStatement.setInt(7, etudiant.getRole().getId());
            preparedStatement.setInt(8, etudiant.getPromotion().getId());
            preparedStatement.setInt(9, etudiant.getSpecialite().getId());
            preparedStatement.setInt(10, etudiant.getFormateur().getId());

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
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setEmail(resultSet.getString("email"));
                    etudiant.setMotDePasse(resultSet.getString("motDePasse"));
                    etudiant.setNom(resultSet.getString("nom"));
                    etudiant.setPrenom(resultSet.getString("prenom"));
                    etudiant.setTelephone(resultSet.getString("telephone"));
                    etudiant.setId(resultSet.getInt("id"));
                    etudiant.setStatut(resultSet.getBoolean("statut"));
                    etudiant.setRole(roleDAO.find(resultSet.getInt("roleId")).get());
                    etudiant.setPromotion(promotionDAO.find(resultSet.getInt("promotionId")).get());
                    etudiant.setSpecialite(specialiteDAO.find(resultSet.getInt("specialiteId")).get());
                    etudiant.setFormateur(formateurDAO.find(resultSet.getInt("formateurId")).get());

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
        String sql = "SELECT * FROM \"" + tableName + "\"";
        List<Etudiant> etudiants = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setEmail(resultSet.getString("email"));
                etudiant.setMotDePasse(resultSet.getString("motDePasse"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setTelephone(resultSet.getString("telephone"));
                etudiant.setStatut(resultSet.getBoolean("statut"));
                etudiant.setId(resultSet.getInt("id"));
                etudiant.setRole(roleDAO.find(resultSet.getInt("roleId")).get());
                etudiant.setPromotion(promotionDAO.find(resultSet.getInt("promotionId")).get());
                etudiant.setSpecialite(specialiteDAO.find(resultSet.getInt("specialiteId")).get());
                etudiant.setFormateur(formateurDAO.find(resultSet.getInt("formateurId")).get());

                etudiants.add(etudiant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return etudiants;
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        String sql = "UPDATE \"" + tableName + "\" SET nom = ?, prenom = ?, email = ?, motDePasse = ?" +
                ", telephone = ?, statut = ?, roleId = ?, promotionId = ?, specialiteId = ?, formateurId = ?" +
                " WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getEmail());
            preparedStatement.setString(4, etudiant.getMotDePasse());
            preparedStatement.setString(5, etudiant.getTelephone());
            preparedStatement.setBoolean(6, etudiant.getStatut());
            preparedStatement.setInt(7, etudiant.getRole().getId());
            preparedStatement.setInt(8, etudiant.getPromotion().getId());
            preparedStatement.setInt(9, etudiant.getSpecialite().getId());
            preparedStatement.setInt(10, etudiant.getFormateur().getId());
            preparedStatement.setInt(11, etudiant.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return etudiant;
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
