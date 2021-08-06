package com.shehriyar.SSSpringBootDemo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/car_rental";
    private static final String DATABASE_USERNAME = "postgres";
    private static final String DATABASE_PASSWORD = "Telenor@123";

    public static Connection make_connection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}

