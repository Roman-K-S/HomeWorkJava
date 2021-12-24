package Lesson_2_7.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SQLAuthService implements AuthService{
    private static Connection connection;
    private static Statement stmt;
    private static final Logger logger = LogManager.getLogger(SQLAuthService.class);

    @Override
    public void start() {
        logger.info("Сервис аутентификации запущен");
        try {
            connect();
            logger.info("Связь с базой данных установлена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
//    public String getNickByLoginPass(String login, String pass) {
//        try {
//            readEx(login,pass);
//            return
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public String getNickByLoginPass(String login, String pass) {
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT nick FROM users WHERE login = ? AND pass = ?")) {
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
           return ( rs.getString("nick"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void changeNick(String nick, String newNick){
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE users SET nick = ? WHERE nick = ?")) {
            ps.setString(1, newNick);
            ps.setString(2, nick);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        disconnect();
        logger.info("Связь с базой данных разорвана");
        logger.info("Сервис аутентификации остановлен");
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
        stmt = connection.createStatement();
    }

    private void disconnect() {
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
}
