package Lesson_2_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаю клиента...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился.");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner msgInput = new Scanner(System.in);

            while (true){
                String strFromClient = in.readUTF();
                System.out.println(strFromClient);
                if (strFromClient.equals("/end") || msgInput.toString() == "/end"){
                    break;
                }
                if (!msgInput.toString().isEmpty()) {
                    out.writeUTF(msgInput.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
