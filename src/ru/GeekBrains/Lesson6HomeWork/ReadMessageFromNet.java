package ru.GeekBrains.Lesson6HomeWork;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadMessageFromNet extends Thread{
    private static final String FINAL_MESSAGE = "\\finish";
    Socket socket;
    DataInputStream dataInputStream;

    public ReadMessageFromNet(Socket socket, String whoAmI) {
        this.socket = socket;
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println(whoAmI + " готов принимать сообщения");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String MessageFromNet = "";
        do {
            try {
                MessageFromNet = dataInputStream.readUTF();
                System.out.println("From Net: " + MessageFromNet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!FINAL_MESSAGE.equals(MessageFromNet));
        System.out.println("Больше сообщения не принимаются");
    }
}
