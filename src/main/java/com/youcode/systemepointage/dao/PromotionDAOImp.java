package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Promotion;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class PromotionDAOImp implements GenericDAO<Promotion, Integer> {
    private String tableName = "Promotion";

    @Override
    public Promotion create(Promotion promotion) {
//        String sql = "INSERT INTO \"" + tableName + " (\"debut\", \"fin\", \"nom\")" +
//                " VALUES (?, ?, ?)";
//
//        try (Connection connection = ConnectionFactory.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setDate(1, Date.valueOf(promotion.getDebut()));
//            preparedStatement.setDate(2, Date.valueOf(promotion.getFin()));
//            preparedStatement.setString(3, promotion.getNom());
//
//            preparedStatement.executeUpdate();
//
//            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                promotion.setId(generatedKeys.getInt("id"));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return promotion;
    }

    @Override
    public Optional<Promotion> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Promotion> findAll() {
        return null;
    }

    @Override
    public Promotion update(Promotion promotion) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
