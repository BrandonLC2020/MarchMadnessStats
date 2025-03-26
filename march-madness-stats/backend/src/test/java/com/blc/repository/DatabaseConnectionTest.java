package com.blc.repository;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.blc.backend.repository.DatabaseConnection;

public class DatabaseConnectionTest {

    @Test
    public void testGetConnection() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Assert that the connection is not null
            assertNotNull(connection, "Database connection should not be null");
        } catch (Exception e) {
            // Fail the test if an exception occurs
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }
}