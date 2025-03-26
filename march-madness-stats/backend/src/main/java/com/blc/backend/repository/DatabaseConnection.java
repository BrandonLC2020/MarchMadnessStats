package com.blc.backend.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.cdimascio.dotenv.Dotenv;
    
public class DatabaseConnection {
    private static final Dotenv dotenv = Dotenv.configure()
        .directory("../") // Folder containing .env
        .load();
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    private static final String DATABASE_NAME = dotenv.get("DB_NAME");
    private static final String CLOUD_SQL_PUBLIC_IP = dotenv.get("DB_HOST");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    private static final String JDBC_URL = "jdbc:mysql://" + CLOUD_SQL_PUBLIC_IP + ":3306/" + DATABASE_NAME;

    public static Connection getConnection() {
        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // Exception is already logged, no need to print stack trace
            logger.log(Level.SEVERE, "Database connection error", e);
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
