package Lesson_2_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client(){
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")){
                            closeConnection();
                            break;
                        }
                        System.out.println(strFromServer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void closeConnection() {
        try {
            in.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String msgInput) {
        if (!msgInput.isEmpty()){
            try {
                out.writeUTF(msgInput);
            } catch (IOException e){
                e.printStackTrace();
                System.out.println("Ошибка при передаче сообщения.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner msgInput = new Scanner(System.in);

        Client cl = new Client();

        while (msgInput.toString() != "/end") {
                cl.sendMessage(msgInput.nextLine());
        }
        cl.closeConnection();
    }
}
