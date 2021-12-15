package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Administrateur;

import java.util.List;
import java.util.Optional;

public class AdministrateurDAOImp implements AdministrateurDAO {
    private final String tableName = "Administrateur";

    @Override
    public Administrateur create(Administrateur administrateur) {
        return null;
    }

    @Override
    public Optional<Administrateur> find(int id) {
        return Optional.empty();
    }

    @Override
    public List<Administrateur> findAll() {
        return null;
    }

    @Override
    public Administrateur update(Administrateur administrateur) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

//    @Override
//    public Specialite create(Specialite specialite) {
//        String sql = "INSERT INTO \"" + tableName +
//                "\" (\"Specialite\") VALUES (?)";
//
//        try (Connection connection = ConnectionFactory.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setString(1, specialite.getNom());
//
//            preparedStatement.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return specialite;
//    }
//
//    @Override
//    public Optional<Specialite> find(int id) {
//        String sql = "SELECT * FROM \"" + tableName + "\" WHERE \"Id\" = ?";
//
//        try (Connection connection = ConnectionFactory.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setInt(1, id);
//
//            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    Specialite specialite = new Specialite();
//                    specialite.setNom(resultSet.getString("Nom"));
//                    specialite.setId(resultSet.getInt("UtilisateurID"));
//
//                    return Optional.of(specialite);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Specialite> findAll() {
//        String sql = "SELECT * FROM " + tableName;
//        List<Specialite> specialiteList = new ArrayList<>();
//
//        try (Connection connection = ConnectionFactory.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                Specialite specialite = new Specialite();
//                specialite.setNom(resultSet.getString("Nom"));
//                specialite.setId(resultSet.getInt("SpecialiteID"));
//
//                specialiteList.add(specialite);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return specialiteList;
//    }
//
//    @Override
//    public Specialite update(Specialite specialite) {
//        String sql = "UPDATE " + tableName + " SET Nom = ? WHERE id = ?";
//
//        try (Connection connection = ConnectionFactory.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setString(1, specialite.getNom());
//            preparedStatement.setInt(2, specialite.getId());
//
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return specialite;
//    }
//
//    @Override
//    public Specialite delete(Specialite specialite) {
//        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
//
//        try (Connection connection = ConnectionFactory.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setInt(1, specialite.getId());
//
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return specialite;
//    }
}
