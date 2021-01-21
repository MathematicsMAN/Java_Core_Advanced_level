package ru.GeekBrains.Lesson6HomeWork;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final String IPHost = "localhost";
    private static final int port = 8081;

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket(IPHost, port);
        System.out.println("Подключение к серверу прошло успешно");

        var taskReadMessageFromConsole = new ReadMessageFromConsole(socket,"Клиент");
        var taskReadMessageFromNet = new ReadMessageFromNet(socket,"Клиент");

        taskReadMessageFromConsole.start();
        taskReadMessageFromNet.start();

        while(taskReadMessageFromConsole.isAlive() || taskReadMessageFromNet.isAlive()) {

        }
        socket.close();
        System.out.println("Соединение разорвано");
    }
}
