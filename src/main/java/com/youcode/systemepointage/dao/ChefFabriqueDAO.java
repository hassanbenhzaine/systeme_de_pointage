//package com.youcode.systemepointage.dao;
//
//import com.youcode.systemepointage.shared.ConnectionFactory;
//import com.youcode.systemepointage.dao.DAO;
//import com.youcode.systemepointage.model.ChefFabrique;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class ChefFabriqueDAO implements DAO<ChefFabrique> {
//    private final String tableName = "ChefFabrique";
//
//    @Override
//    public List<ChefFabrique> findAll() {
//        String sql = "SELECT * FROM " + tableName;
//
//        List<ChefFabrique> chefFabriques = new ArrayList<>();
//
//        try (Connection connection = ConnectionFactory.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
////                ChefFabrique chefFabrique = new ChefFabrique();
////                chefFabrique.setId(resultSet.getInt("CheffabriqueID"));
////                chefFabrique.setNom(resultSet.getString("Nom"));
////                chefFabrique.setPrenom(resultSet.getString("Prenom"));
////                chefFabrique.setEmail(resultSet.getString("Email"));
////                chefFabrique.setMotDePasse(resultSet.getString("MotDePasse"));
////                chefFabrique.setTelephone(resultSet.getInt("Telephone"));
////                chefFabrique.setEntreeFabrique(resultSet.getDate("EntreeFabrique"));
////
////                chefFabriques.add(chefFabrique);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return chefFabriques;
//    }
//
//    @Override
//    public int create(ChefFabrique chefFabrique) {
//        String sql = "INSERT INTO " + tableName + " VALUES (?,?,?,?)";
//
//        try (Connection connection = ConnectionFactory.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setDate(1, chefFabrique.getEntreeFabrique());
//            preparedStatement.setInt(2, chefFabrique.getId());
//
//            preparedStatement.executeUpdate();
//            return 1;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 2;
//        }
//    }
//
//
//    @Override
//    public Optional<ChefFabrique> find(int id) {
//        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
//
//        try (Connection connection = ConnectionFactory.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setInt(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                ChefFabrique chefFabrique = new ChefFabrique();
////                chefFabrique.setId(resultSet.getInt("CheffabriqueID"));
////                chefFabrique.setNom(resultSet.getString("Nom"));
////                chefFabrique.setPrenom(resultSet.getString("Prenom"));
////                chefFabrique.setEmail(resultSet.getString("Email"));
////                chefFabrique.setMotDePasse(resultSet.getString("MotDePasse"));
////                chefFabrique.setTelephone(resultSet.getInt("Telephone"));
////                chefFabrique.setEntreeFabrique(resultSet.getDate("EntreeFabrique"));
//
//                return Optional.of(chefFabrique);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return Optional.empty();
//    }
//
//    @Override
//    public int update(ChefFabrique chefFabrique) {
////        String sql = "UPDATE " + tableName + " SET Nom = ?, Prenom = ?, Email = ?, MotDePasse = ? WHERE id = ?";
////
////        try (Connection connection = ConnectionFactory.getInstance().getConnection();
////             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
////
////            preparedStatement.setString(1, chefFabrique.getNom());
////            preparedStatement.setString(2, chefFabrique.getPrenom());
////            preparedStatement.setString(3, chefFabrique.getEmail());
////            preparedStatement.setString(4, chefFabrique.getMotDePasse());
////            preparedStatement.setInt(5, chefFabrique.getId());
////
////            preparedStatement.executeUpdate();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        return 1;
//    }
//
//    @Override
//    public int delete(ChefFabrique chefFabrique) {
//        return 0;
//    }
//}
//
