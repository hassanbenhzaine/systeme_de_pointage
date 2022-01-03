package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdresseDAOImp implements GenericDAO<Adresse, Integer> {
    private final String TABLE_NAME = "Adresse";

    @Override
    public Adresse create(Adresse adresse) {
        String sql = "INSERT INTO \"" + TABLE_NAME +
                "\" (\"adresse1\", \"adresse2\", \"pays\", \"region\", \"ville\", \"codePostal\", \"utilisateurId\")"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, adresse.getAdresse1());
            preparedStatement.setString(2, adresse.getAdresse2());
            preparedStatement.setString(3, adresse.getPays());
            preparedStatement.setString(4, adresse.getRegion());
            preparedStatement.setString(5, adresse.getVille());
            preparedStatement.setInt(6, adresse.getCodePostal());
            preparedStatement.setInt(7, adresse.getUtilisateurId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                adresse.setId(rs.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return adresse;
    }

    @Override
    public Optional<Adresse> find(Integer id) {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Adresse adresse = new Adresse();
                    adresse.setId(resultSet.getInt("id"));
                    adresse.setAdresse1(resultSet.getString("adresse1"));
                    adresse.setAdresse2(resultSet.getString("adresse2"));
                    adresse.setPays(resultSet.getString("pays"));
                    adresse.setRegion(resultSet.getString("region"));
                    adresse.setVille(resultSet.getString("ville"));
                    adresse.setCodePostal(resultSet.getInt("codePostal"));
                    adresse.setUtilisateurId(resultSet.getInt("utilisateurId"));

                    return Optional.of(adresse);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Adresse> findAll() {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\"";
        List<Adresse> chefFabriques = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Adresse adresse = new Adresse();
                adresse.setAdresse1(resultSet.getString("adresse1"));
                adresse.setAdresse2(resultSet.getString("adresse2"));
                adresse.setPays(resultSet.getString("pays"));
                adresse.setRegion(resultSet.getString("region"));
                adresse.setVille(resultSet.getString("ville"));
                adresse.setCodePostal(resultSet.getInt("codePostal"));
                adresse.setUtilisateurId(resultSet.getInt("utilisateurId"));

                chefFabriques.add(adresse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chefFabriques;
    }

    @Override
    public Adresse update(Adresse adresse) {
        String sql = "UPDATE \"" + TABLE_NAME +
                "\" SET adresse1 = ?, adresse2 = ?, pays = ?, region = ?, ville = ?, \"codePostal\" = ?, \"utilisateurId\" = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, adresse.getAdresse1());
            preparedStatement.setString(2, adresse.getAdresse2());
            preparedStatement.setString(3, adresse.getPays());
            preparedStatement.setString(4, adresse.getRegion());
            preparedStatement.setString(5, adresse.getVille());
            preparedStatement.setInt(6, adresse.getCodePostal());
            preparedStatement.setInt(7, adresse.getUtilisateurId());
            preparedStatement.setInt(8, adresse.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adresse;
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
