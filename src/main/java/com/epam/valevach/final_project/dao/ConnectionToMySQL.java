package com.epam.valevach.final_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToMySQL {
    String dbName = "grand_service";
    String dbHost = "localhost";
    String dbPort = "3306";
    String dbUser = "root";
    String dbPass = "ivatich";
    String urlDb = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

    private ConnectionToMySQL() {
    }

    private static ConnectionToMySQL connectionCreator = new ConnectionToMySQL();

    public static ConnectionToMySQL getMysqlConnection() {
        return connectionCreator;
    }

    public Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(urlDb, dbUser, dbPass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
