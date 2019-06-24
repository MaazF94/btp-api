package com.btp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConnector {

    private Connection conn = null;

    public DbConnector(@Value("${spring.datasource.url}") String connectionUrl,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password, 
            @Value("${spring.datasource.name}") String dbName,
            @Value("${spring.datasource.driver-class-name}") String driverClassName) {
        try {
            Class.forName(driverClassName);
            try {
                conn = DriverManager.getConnection(connectionUrl + username + password + dbName);
            } catch (SQLException e) {
                System.out.println("Cant get connection");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver manager not found");
            e.printStackTrace();

        }
    }

    /**
     * gets connection
     * 
     * @return connection
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * closes connection
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Cant close connection");
            e.printStackTrace();
        }
    }
}