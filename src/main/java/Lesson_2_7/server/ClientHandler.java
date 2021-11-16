package Lesson_2_7.server;

import Lesson_2_7.constants.Const;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer myServer, Socket socket){
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }

    private void closeConnection() {
        myServer.unsubscribe(this);
        myServer.broadcastMsg(name + " вышел из чата");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessages() throws IOException {
        while (true) {
            String strFromClient = in.readUTF();
            if (strFromClient.startsWith(Const.CLIENTS_LIST_COMMAND)) {
                sendMsg(myServer.getActiveClients());
            } else if (strFromClient.startsWith(Const.CLIENTS_WHISPER)) {
                String[] tokens = strFromClient.split("\\s+");
                int serviceTokenLength = tokens[0].length()+ tokens[1].length();
                String whisperMsg = (name + " шепчет: " + strFromClient.substring(serviceTokenLength + 1));
                myServer.whisper(tokens[1], whisperMsg);
            } else {
                System.out.println("от " + name + ": " + strFromClient); // логирование сообщений в консоль
                if (strFromClient.equals(Const.END_COMMAND)) {
                    return;
                }
                myServer.broadcastMsg(name + ": " + strFromClient);
            }
        }
    }


    private void authentication() throws IOException{
        while (true){
            String str = in.readUTF();
            if (str.startsWith(Const.AUTH_COMMAND)) {
                String[] parts = str.split("\\s+");
                String nick = myServer.getAuthService().getNickByLoginPass(parts[1],parts[2]);
                if (nick != null) {
                    if (!myServer.isNickBusy(nick)) {
                        sendMsg(Const.AUTH_OK_COMMAND + " " + nick);
                        name = nick;
                        myServer.broadcastMsg(name + " зашёл в чат");
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMsg("Учётная запись уже используется");
                    }
                } else {
                    sendMsg ("Неверный логин/пароль");
                }
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}