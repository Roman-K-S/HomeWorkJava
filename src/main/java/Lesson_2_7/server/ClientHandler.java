package Lesson_2_7.server;

import Lesson_2_7.constants.Const;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    ExecutorService service = Executors.newFixedThreadPool(2);

    private String name;
    private boolean authorized;

    public String getName() {
        return name;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public ClientHandler(MyServer myServer, Socket socket){
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            this.authorized = false;
            service.execute(() -> {
                try {
                    authentication();
                    readMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            });

            service.execute(new Runnable() {
                @Override
                public void run() {
                    int counterTimeAuth = 120;
                    while (true) {
                        int finalCounterTimeAuth = counterTimeAuth;
                        if (finalCounterTimeAuth == 0 && !isAuthorized()) {
                            sendMsg("Время вышло. Закрываем соединение");
                            closeConnection();
                            break;
                        }else if(isAuthorized()){
                            break;
                        }
                        Thread t1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                sendMsg("Время на авторизацию: " + finalCounterTimeAuth + " секунд " + isAuthorized());
                            }
                        });
                        t1.start();
                        counterTimeAuth -= 5;
                        try {
                            t1.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
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
                String whisperMsgTo = ("Вам шепчет " + name + ": " + strFromClient.substring(serviceTokenLength + 1));
                String whisperMsgFrom = ("Вы шепнули " + tokens[1] + ": " + strFromClient.substring(serviceTokenLength + 1));
                myServer.whisper(tokens[1], whisperMsgTo);
                myServer.whisper(this.name, whisperMsgFrom);
            } else if (strFromClient.startsWith(Const.CHANGE_NICK)) {
                String[] tokens = strFromClient.split("\\s+");
                myServer.getAuthService().changeNick(this.name, tokens[1]);
                myServer.broadcastMsg(this.name + " сменил ник на: " + tokens[1]);
                this.name = tokens[1];
            } else {
                System.out.println("от " + name + ": " + strFromClient); // логирование сообщений в консоль
                if (strFromClient.equals(Const.END_COMMAND)) {
                    sendMsg("/end");
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
                        setAuthorized(true);
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
