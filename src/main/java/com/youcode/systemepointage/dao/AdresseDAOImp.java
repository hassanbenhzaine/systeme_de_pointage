package com.youcode.systemepointage.dao;

import com.youcode.systemepointage.model.Adresse;
import com.youcode.systemepointage.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class AdresseDAOImp implements AdresseDAO{
    private String tableName = "Adresse";
    @Override
    public Adresse create(Adresse adresse) {
        String sql = "INSERT INTO \"" + tableName +
                " (\"Adresse1\", \"Adresse2\", \"Pays\", \"Region\", \"Ville\", \"CodePostal\", \"UtilisateurID\")"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, adresse.getAdresse1());
            preparedStatement.setString(2, adresse.getAdresse2());
            preparedStatement.setString(3, adresse.getPays());
            preparedStatement.setString(4, adresse.getRegion());
            preparedStatement.setString(5, adresse.getVille());
            preparedStatement.setInt(6, adresse.getCodePostal());
            preparedStatement.setInt(7, adresse.getUtilisateur().getId());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return adresse;
    }

    @Override
    public Optional<Adresse> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Adresse> findAll() {
        return null;
    }

    @Override
    public Adresse update(Adresse adresse) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
