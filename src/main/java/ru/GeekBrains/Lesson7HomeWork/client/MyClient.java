package ru.GeekBrains.Lesson7HomeWork.client;

import ru.GeekBrains.Lesson7HomeWork.server.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyClient extends JFrame {

    private ServerService serverService;
    private String login;
    private String password;
    private String nick;
    private volatile boolean runConnection = true;

    public MyClient(String login, String password) {
        super("Чат");
        this.login = login;
        this.password = password;

        serverService = new SocketServerService();
        this.nick = serverService.openConnection(this.login, this.password);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setBounds(400, 400, 500, 500);

        TextArea mainChat = new TextArea();
        mainChat.setSize( 100, 300);

        TextArea myMessage = new TextArea();
        myMessage.setSize(100, 300);

        Button send = new Button("Send");
        send.setSize(50,200);
        send.addActionListener(actionEvent -> sendMessage(myMessage));

        myMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER && runConnection) {
                    sendMessage(myMessage);
                }
            }
        });

        new Thread(() -> {
            while (runConnection) {
                Message message = serverService.readMessages();
                printToUI(mainChat, message);
                if ("/end".equals(message.getMessage())){
                    serverService.closeConnection();
                    runConnection = false;
                    break;
                }
            }
        }).start();

        add(mainChat);
        add(myMessage);
        add(send);
    }

    private void sendMessage(TextArea myMessage) {
        serverService.sendMessage(myMessage.getText());
        myMessage.setText("");
        if ("/end".equals(myMessage.getText())){
            serverService.closeConnection();
        }
    }

    private void printToUI(TextArea mainChat, Message message) {
        mainChat.append("\n");
        mainChat.append(message.getNick()+" написал: "+message.getMessage());
    }
}
