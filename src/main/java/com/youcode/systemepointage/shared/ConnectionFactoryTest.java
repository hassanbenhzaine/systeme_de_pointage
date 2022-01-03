package com.youcode.systemepointage.shared;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTest {
    public Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            System.out.println("unabling to get Connection : " + e);
            throw  new RuntimeException("unabling to get Connection : ");
        }
    }
    private DataSource getDataSource(){
        DataSource dataSource = null;
        EmbeddedPostgres postgres = null;
        try {
            postgres= postgres.builder().start();
            dataSource = postgres.getPostgresDatabase();
        } catch (IOException e) {
            System.out.println("unabling to start elbededPotgress : " + e);
        }
        Flyway flyway = getFlyway(dataSource);
        flyway.clean();
        flyway.migrate();
        return  dataSource;
    }

    private Flyway getFlyway(final  DataSource dataSource){
        FluentConfiguration configuration = Flyway.configure().dataSource(dataSource);
        return new Flyway(configuration);
    }
}


