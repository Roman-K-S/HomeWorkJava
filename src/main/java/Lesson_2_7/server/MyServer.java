package Lesson_2_7.server;

import Lesson_2_7.constants.Const;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyServer {

    private List<ClientHandler> clients;
    private AuthService authService;

    public  AuthService getAuthService() {
        return authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket (Const.SERVER_PORT)) {
            authService = new SQLAuthService();
            authService.start();

            clients = new ArrayList<>();

            while (true){
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка в работе сервера");
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized boolean isNickBusy (String nick) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void broadcastMsg (String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public synchronized void whisper (String nick, String msg) {
        for (ClientHandler o : clients){
            if (o.getName().equals(nick)) {
                o.sendMsg(msg);
            }
        }
    }

    public synchronized void unsubscribe (ClientHandler o) {
        clients.remove(o);
        getActiveClients();
    }

    public synchronized void subscribe (ClientHandler o) {
        clients.add(o);
        getActiveClients();
    }

    public synchronized String getActiveClients() {
        StringBuilder sb = new StringBuilder();
        sb.append(clients.stream()
                .map(c -> c.getName())
                .collect(Collectors.joining(" "))
        );
        return sb.toString();

        /*for (ClientHandler clientHandler : clients) {
            sb.append(clientHandler.getName()).append(" ");
        }*/

    } // end getActiveClients
}
