package com.blc.backend.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class DatabaseConnectionTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionTest.class);

    // This will start a SQL Server Docker container for our tests
    @Container
    private static final MSSQLServerContainer<?> sqlServerContainer =
            new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2022-latest")
                    .acceptLicense();

    @BeforeAll
    static void beforeAll() {
        // The dotenv library checks system properties before .env files.
        // We override the .env properties for our test run by setting them here
        // with dynamic values from the Testcontainer.
        System.setProperty("DB_HOST", sqlServerContainer.getHost());
        System.setProperty("DB_PORT", String.valueOf(sqlServerContainer.getMappedPort(MSSQLServerContainer.MS_SQL_SERVER_PORT)));
        System.setProperty("DB_NAME", sqlServerContainer.getDatabaseName());
        System.setProperty("DB_USER", sqlServerContainer.getUsername());
        System.setProperty("DB_PASSWORD", sqlServerContainer.getPassword());
        LOGGER.info("Overriding .env properties for Testcontainers.");
    }

    @Test
    void testGetConnection_successfullyConnectsToTestContainer() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            assertNotNull(connection, "Connection should not be null.");
            assertFalse(connection.isClosed(), "Connection should be open.");

            // Run a simple query to be 100% sure the connection is working
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery("SELECT 1")) {
                assertTrue(rs.next(), "Query should return at least one row.");
                assertEquals(1, rs.getInt(1), "Query should return the value 1.");
                LOGGER.info("Successfully executed a test query against the test container.");
            }
        } catch (Exception e) {
            fail("Should not have thrown any exception during connection test.", e);
        }
    }

    @AfterAll
    static void afterAll() {
        // The @Testcontainers annotation handles stopping the container automatically.
        LOGGER.info("Test container will be stopped automatically.");
    }
}