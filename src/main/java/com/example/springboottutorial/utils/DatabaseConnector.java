package com.example.springboottutorial.utils;

import org.mariadb.jdbc.MariaDbPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector {
    String databaseUrl = ConfigurationReader.getInstance().getProperties().getProperty("spring.datasource.url")
            +"?user="
            +ConfigurationReader.getInstance().getProperties().getProperty("spring.datasource.username")
            +"&password="
            +ConfigurationReader.getInstance().getProperties().getProperty("spring.datasource.password")
            +"&maxPoolSize="
            +ConfigurationReader.getInstance().getProperties().getProperty("spring.datasource.pool.size");
    private final MariaDbPoolDataSource pool = new MariaDbPoolDataSource(databaseUrl);
    private static final DatabaseConnector databaseConnector= new DatabaseConnector();
    private DatabaseConnector() {
    }
    public static DatabaseConnector getInstant(){
        return databaseConnector;
    }
    public static MariaDbPoolDataSource getPool() {
        return databaseConnector.pool;
    }
    public static Connection getConnection() throws SQLException {
        return databaseConnector.pool.getConnection();
    }
}
