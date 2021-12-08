package Lesson_2_7.server;

public interface AuthService {
    void start();
    String getNickByLoginPass (String login, String pass);
    void changeNick(String nick, String newNick);
    void stop();
}
