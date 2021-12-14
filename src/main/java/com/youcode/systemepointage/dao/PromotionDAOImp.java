package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.shared.ConnectionFactory;
import com.youcode.systemepointage.model.Promotion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class PromotionDAOImp implements PromotionDAO {
    private String tableName = "promotion";
//
//    @Override
//    public Promotion create(Promotion promotion) {
//        String sql = "INSERT INTO \"" + tableName + " (\"Debut\", \"Fin\", \"Nom\")" +
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
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return promotion;
//    }
//
//    @Override
//    public Optional<Promotion> find(int id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Promotion> findAll() {
//        return null;
//    }
//
//    @Override
//    public Promotion update(Promotion promotion) {
//        return null;
//    }
//
//    @Override
//    public Promotion delete(Promotion promotion) {
//        return null;
//    }
}
