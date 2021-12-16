package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Specialite;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpecialiteDAOImp implements SpecialiteDAO {
    private final String tableName = "Specialite";

    @Override
    public Specialite create(Specialite specialite) {
        String sql = "INSERT INTO \"" + tableName +
                "\" (\"nom\") VALUES (?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, specialite.getNom());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                specialite.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return specialite;
    }

    @Override
    public Optional<Specialite> find(Integer id) {
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Specialite specialite = new Specialite();
                    specialite.setNom(resultSet.getString("nom"));
                    specialite.setId(resultSet.getInt("id"));

                    return Optional.of(specialite);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Specialite> findAll() {
        String sql = "SELECT * FROM " + tableName;
        List<Specialite> specialiteList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Specialite specialite = new Specialite();
                specialite.setNom(resultSet.getString("nom"));
                specialite.setId(resultSet.getInt("id"));

                specialiteList.add(specialite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return specialiteList;
    }

    @Override
    public Specialite update(Specialite specialite) {
        String sql = "UPDATE " + tableName + " SET nom = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, specialite.getNom());
            preparedStatement.setInt(2, specialite.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return specialite;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}

