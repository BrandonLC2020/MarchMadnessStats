package com.blc.backend.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConnection {

    // Load environment variables from the .env file
    private static final Dotenv dotenv = Dotenv.configure()
        .directory("../") // Folder containing .env
        .load();
    
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    // Retrieve database connection parameters from environment variables
    private static final String DB_NAME = dotenv.get("DB_NAME", "default_db_name");
    private static final String CLOUD_SQL_INSTANCE = dotenv.get("CLOUD_SQL_INSTANCE", "localhost");
    private static final String DB_USER = dotenv.get("DB_USER", "root");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD", "password");

    // JDBC URL format
    private static final String JDBC_URL = String.format("jdbc:mysql://google/%s?cloudSqlInstance=%s&socketFactory=com.google.cloud.sql.mysql.SocketFactory",
                                       DB_NAME,
                                       CLOUD_SQL_INSTANCE);

    // Static block to ensure MySQL driver is loaded only once at class initialization
    static {
        try {
            // MySQL driver is automatically loaded with JDBC 4.0+, so no need to call Class.forName
            // Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error loading MySQL driver", e);
        }
    }

    /**
     * Returns a connection to the database.
     * @return A connection to the MySQL database.
     * @throws RuntimeException if the connection could not be established.
     */
    public static Connection getConnection() {
        try {
            // Log the connection attempt (sensitive info like password is not logged)
            logger.log(Level.INFO, "Attempting to connect to database {0} at {1}",
                    new Object[] { DB_NAME, CLOUD_SQL_INSTANCE });

            // Return a connection to the database
            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            // Log SQL errors
            logger.log(Level.SEVERE, "Database connection failed", e);
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
