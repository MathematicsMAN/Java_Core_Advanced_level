package ru.GeekBrains.Lesson6HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String FINAL_MESSAGE = "\\finish";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8081);
        System.out.println("Подключение к серверу прошло успешно");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println("Готов принимать сообщения");
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("Готов отправлять сообщения");
        Runnable taskReadMessageFromConsole = () ->{
            String MessageFromConsole;
            Scanner scanner = new Scanner(System.in);
            do {
                MessageFromConsole = scanner.nextLine();
                try {
                    dataOutputStream.writeUTF(MessageFromConsole);
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while(!FINAL_MESSAGE.equals(MessageFromConsole));
            System.out.println("Больше сообщения не отправляются");
        };
        Runnable taskReadMessageFromServer = () ->
        {
            String MessageFromServer = "";
            do {
                try {
                    MessageFromServer = dataInputStream.readUTF();
                    System.out.println("From server: " + MessageFromServer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!FINAL_MESSAGE.equals(MessageFromServer));
            System.out.println("Больше сообщения не принимаются");

        };

        new Thread(taskReadMessageFromConsole).start();
        new Thread(taskReadMessageFromServer).start();

        if(!(((Thread)taskReadMessageFromConsole).isAlive() || ((Thread)taskReadMessageFromServer).isAlive())) {
            socket.close(); //клиент "умирает" и закрывает все соединения
            System.out.println("Соединение с сервером разорвано");
        }

    }
}
