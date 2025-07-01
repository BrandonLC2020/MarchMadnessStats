package com.blc.backend.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Manages database connections using environment variables.
 * This class is designed to connect to a SQL Server instance on a Google Cloud VM.
 */
public class DatabaseConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnection.class.getName());
    private static final Dotenv dotenv;

    private static final String DB_HOST;
    private static final String DB_PORT;
    private static final String DB_NAME;
    private static final String DB_USER;
    private static final String DB_PASSWORD;
    private static final String JDBC_URL;

    static {
        // Load environment variables from .env file in the project root.
        // It assumes the .env file is in the parent directory of the 'backend' module.
        dotenv = Dotenv.configure().directory("../").ignoreIfMissing().load();

        DB_HOST = getEnv("DB_HOST");
        DB_PORT = getEnv("DB_PORT", "1433"); // Default SQL Server port
        DB_NAME = getEnv("DB_NAME");
        DB_USER = getEnv("DB_USER");
        DB_PASSWORD = getEnv("DB_PASSWORD");

        // Construct the JDBC URL for SQL Server.
        // Using encrypt=true is recommended for security.
        // trustServerCertificate=true is used for simplicity; for production,
        // you should configure a proper trust store.
        JDBC_URL = String.format(
            "jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=true;trustServerCertificate=true",
            DB_HOST, DB_PORT, DB_NAME
        );

        LOGGER.info("Database connection configured for host: {}", DB_HOST);
        LOGGER.info("DB_USER: {}", DB_USER);
    }

    private static String getEnv(String key) {
        String value = dotenv.get(key);
        if (value == null || value.trim().isEmpty()) {
            String errorMessage = "Missing required environment variable: " + key + ". Please ensure it is set in your .env file.";
            LOGGER.error(errorMessage);
            throw new IllegalStateException(errorMessage);
        }
        return value;
    }

    private static String getEnv(String key, String defaultValue) {
        String value = dotenv.get(key);
        return (value == null || value.trim().isEmpty()) ? defaultValue : value;
    }

    /**
     * Establishes a connection to the SQL Server database.
     *
     * @return A Connection object to the database.
     * @throws RuntimeException if a database access error occurs.
     */
    public static Connection getConnection() {
        try {
            // The SQL Server driver is loaded automatically via the Service Provider Interface (SPI)
            // as long as the mssql-jdbc JAR is on the classpath.
            LOGGER.info("Attempting to connect to database...");
            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("Database connection failed.", e);
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static void main(String[] args) {
        LOGGER.info("Testing database connection...");
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
                LOGGER.info("Connection to SQL Server was successful!");
            }
        } catch (Exception e) {
            // The exception is already logged in getConnection()
        }
    }
}