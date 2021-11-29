package Lesson_2_7.server;

import java.sql.*;

public class JdbcApp {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();
            readEx();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    } // end main

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void readEx() throws SQLException {
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM users;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("Surname") + " "
                + rs.getString("Name"));
            }
        }
    }
}
