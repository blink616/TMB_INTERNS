package com.JDBC.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private String url = "jdbc:postgresql://localhost:5432/jdbcExample";
    private String user = "postgres";
    private String pass = "root123";

    public Connection makeConnection(){
        Connection connection= null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            return  connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
