//package Lesson_2_7.server;
//
//import java.sql.*;
//
//public class JdbcApp {
//    private static Connection connection;
//    private static Statement stmt;
//
//    public static void main(String[] args) {
//        try {
//            connect();
//         //   getNick("login1","pass3");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            disconnect();
//        }
//    } // end main
//
//    public static void connect() throws SQLException {
//        connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
//        stmt = connection.createStatement();
//    }
//
//    public static void disconnect() {
//        try {
//            if (stmt != null) {
//                stmt.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
////    public static void readEx() throws SQLException {
////        try (ResultSet rs = stmt.executeQuery("SELECT nick FROM users WHERE login = 'login2' AND pass = 'pass2' ")) {
////            while (rs.next()) {
////                System.out.println(rs.getString("nick"));
//////                System.out.println(rs.getInt("id") + " " + rs.getString("login") + " "
//////                + rs.getString("pass") + " " + rs.getString("nick"));
////            }
////        }
////    }
//
//    public static void readEx(String login, String pass) throws SQLException {
//        try (PreparedStatement ps = connection.prepareStatement(
//                "SELECT nick FROM users WHERE login = ? AND pass = ?")) {
//            ps.setString(1, login);
//            ps.setString(2, pass);
//            ResultSet rs = ps.executeQuery();
//            System.out.println( rs.getString("nick"));
//        }
//    }
//}
