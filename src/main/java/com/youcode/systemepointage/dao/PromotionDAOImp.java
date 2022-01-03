package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Promotion;
import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PromotionDAOImp implements GenericDAO<Promotion, Integer> {
    private String TABLE_NAME = "Promotion";
    Connection connection;
    public PromotionDAOImp() {
    }

    public PromotionDAOImp(Connection connection) {
        this.connection = connection;
    }


    {
        try {
            connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Promotion create(Promotion promotion) {
      String sql = "INSERT INTO \"" + TABLE_NAME + " (\"debut\", \"fin\", \"nom\")" +
                " VALUES (?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setDate(1, Date.valueOf(promotion.getDebut()));
            preparedStatement.setDate(2, Date.valueOf(promotion.getFin()));
            preparedStatement.setString(3, promotion.getNom());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                promotion.setId(generatedKeys.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotion;
    }

    @Override
    public Optional<Promotion> find(Integer id) {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Promotion promotion = new Promotion();
                    promotion.setDebut(resultSet.getDate("debut").toLocalDate());
                    promotion.setFin(resultSet.getDate("fin").toLocalDate());
                    promotion.setNom(resultSet.getString("nom"));

                    return Optional.of(promotion);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Promotion> findAll() {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\"";
        List<Promotion> promotions = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Promotion promotion= new Promotion();
                promotion.setFin(resultSet.getDate("debut").toLocalDate());
                promotion.setDebut(resultSet.getDate("fin").toLocalDate());
                promotion.setNom(resultSet.getString("nom"));
                promotions.add(promotion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotions;
    }

    @Override
    public Promotion update(Promotion promotion) {
        String sql = "UPDATE public.\"Promotion\"\n" +
                "\tSET debut=?, fin=?, nom=?\n" +
                "\tWHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDate(1, Date.valueOf(promotion.getDebut()));
            preparedStatement.setDate(2, Date.valueOf(promotion.getFin()));
            preparedStatement.setString(3, promotion.getNom());
            preparedStatement.setInt(4, promotion.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotion;
    }

    @Override
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
