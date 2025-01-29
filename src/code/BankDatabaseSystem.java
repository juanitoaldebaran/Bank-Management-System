package code;

import java.sql.*;

public class BankDatabaseSystem {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bank_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aldebaran1711";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnected();
            System.out.println("Successfully connected to database connection!");
        } catch (SQLException e) {
            System.out.println("Failed to get SQL Connection");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error to get SQL Connection");
            e.printStackTrace();
        } finally {
            closedConnection(connection);
        }
    }


    private static Connection getConnected() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

    private static void closedConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Successfully closed connection to database!");
            } catch (SQLException e) {
                System.out.println("Failed to closed connection to database");
                e.printStackTrace();
            }
        }
    }

}
