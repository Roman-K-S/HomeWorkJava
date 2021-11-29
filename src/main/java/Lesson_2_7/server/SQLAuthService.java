package Lesson_2_7.server;

import java.sql.SQLException;

public class SQLAuthService implements AuthService{

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
        try {
            JdbcApp.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getNickByLoginPass(String login, String pass) {
        return null;
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
        JdbcApp.disconnect();
    }
}
