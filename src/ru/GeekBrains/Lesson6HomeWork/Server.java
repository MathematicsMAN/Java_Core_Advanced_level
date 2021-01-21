package ru.GeekBrains.Lesson6HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int port = 8081;

    public static void main(String[] args) throws IOException {

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Создан серверный сокет");
            System.out.println("Ожидаем подключение клиента");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            var taskReadMessageFromConsole = new ReadMessageFromConsole(socket,"Сервер");
            var taskReadMessageFromNet = new ReadMessageFromNet(socket,"Сервер");

            taskReadMessageFromConsole.start();
            taskReadMessageFromNet.start();

            while(taskReadMessageFromConsole.isAlive() || taskReadMessageFromNet.isAlive()) {

            }
            socket.close();
            System.out.println("Соединение разорвано");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
