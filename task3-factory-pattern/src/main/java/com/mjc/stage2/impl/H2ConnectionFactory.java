package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {

    private static final String PROPERTIES_FILE = "h2database.properties";

    @Override
    public Connection createConnection() {
        Properties properties = loadProperties();
        String jdbcDriver = properties.getProperty("jdbc_driver");
        String dbUrl = properties.getProperty("db_url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        try {
            Class.forName(jdbcDriver);
            return DriverManager.getConnection(dbUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}



