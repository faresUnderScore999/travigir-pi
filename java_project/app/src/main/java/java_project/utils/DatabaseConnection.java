package main.java.java_project.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private final String URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7814865?useSSL=false&serverTimezone=UTC";
    private final String USER = "sql7814865";
    private final String PASSWORD = "8DDgEIrFGJ";

    private DatabaseConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
