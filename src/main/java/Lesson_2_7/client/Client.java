package Lesson_2_7.client;

import Lesson_2_7.constants.Const;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static Lesson_2_7.constants.Const.*;

public class Client extends JFrame {
    private JTextField msgInputField;
    private JTextArea chatArea;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String login;

    public Client(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                prepareGUI();
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                while (true) {
                    String messageFromServer = in.readUTF();
                    if (messageFromServer.equals(END_COMMAND)) {
                        break;
                    } else if (messageFromServer.startsWith(Const.AUTH_OK_COMMAND)) {
                        String[] tokens = messageFromServer.split("\\s+");
                        this.login = tokens[1];
                        chatArea.append("Успешно авторизован как " + login);
                        chatArea.append("\n");
                    }else if (messageFromServer.startsWith(Const.CLIENTS_LIST_COMMAND)) {
                        //список клиентов
                    } else {
                        chatArea.append(messageFromServer);
                        chatArea.append("\n");
                    }
                }
                chatArea.append("Соединение разорвано");
                msgInputField.setEnabled(false);
                closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
//                try {
//                    while (true) {
//                        String strFromServer = in.readUTF();
//                        if(strFromServer.startsWith(AUTH_OK_COMMAND)) {
//                            String[] tokens = strFromServer.split("\\s+");
//                            this.login = tokens[1];
//  --> Не видно логина в анонимном классе.
//                            chatArea.append("Авторизация логина " + login + " прошла успешно.");
//                            chatArea.append("\n");
//                        }
//                        chatArea.append(strFromServer + "\n");
//                    }
//                    while (true) {
//                        String strFromServer = in.readUTF();
//                        if (strFromServer.equalsIgnoreCase("/end")) {
//                            break;
//                        }
//                        chatArea.append(strFromServer);
//                        chatArea.append("\n");
//                    }
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }
        }).start();
    }  // end openConnection

    private void closeConnection() {
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
    } // end closeConnection

    public void prepareGUI() {
        //windows param
        setBounds(600, 300, 500, 500);
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Text Area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        //Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Send");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);

        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        msgInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        /**
         * Windows close Action
         */
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF(END_COMMAND);
                    closeConnection();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });

        setVisible(true);

    } // end prepareGUI()



    private void sendMessage() {
        if (!msgInputField.getText().trim().isEmpty()) {
            try {
                out.writeUTF(msgInputField.getText());
                msgInputField.setText("");
                msgInputField.grabFocus();
            }catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error send message");
            }
        }
    } // end sendMessage



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        });
    }
}
