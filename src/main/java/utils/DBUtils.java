package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=myweb;trustServerCertificate=true;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER); // Register Driver
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.out.println("Driver not found!");
            } catch (SQLException e) {
                System.out.println("Connection failed: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connection established successfully!");
        } else {
            System.out.println("Failed to establish connection.");
        }
    }

}

