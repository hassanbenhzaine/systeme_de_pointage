package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Classe;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClasseDAOImp implements GenericDAO<Classe, Integer> {
    private final String TABLE_NAME = "Classe";

    @Override
    public Classe create(Classe classe) {
        String sql = "INSERT INTO \"" + TABLE_NAME + " (\"nom\", \"debutJournee\", \"finJournee\")" +
                " VALUES (?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setDate(1, Date.valueOf(classe.getNom()));
            preparedStatement.setTime(2, Time.valueOf(classe.getDebutJournee()));
            preparedStatement.setTime(3, Time.valueOf(classe.getFinJournee()));
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                classe.setId(generatedKeys.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return classe;
    }

    @Override
    public Optional<Classe> find(Integer id) {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE \"id\" = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Classe classe = new Classe();
                    classe.setDebutJournee(resultSet.getTime("debutJournee").toLocalTime());
                    classe.setFinJournee(resultSet.getTime("finJournee").toLocalTime());
                    classe.setNom(resultSet.getString("nom"));

                    return Optional.of(classe);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Classe> findAll() {
        String sql = "SELECT * FROM \"" + TABLE_NAME + "\"";
        List<Classe> classes = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Classe classe= new Classe();

                classe.setDebutJournee(resultSet.getTime("debutJournee").toLocalTime());
                classe.setFinJournee(resultSet.getTime("finJournee").toLocalTime());
                classe.setNom(resultSet.getString("nom"));
                classes.add(classe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classes;
    }

    @Override
    public Classe update(Classe classe) {
        String sql = "UPDATE public.\"Promotion\"\n" +
                "\tSET nom=?, debutJournee=?, finJournee=?\n" +
                "\tWHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, Date.valueOf(classe.getNom()));
            preparedStatement.setTime(2, Time.valueOf(classe.getDebutJournee()));
            preparedStatement.setTime(3, Time.valueOf(classe.getFinJournee()));
            preparedStatement.setInt(4, classe.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classe;
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
