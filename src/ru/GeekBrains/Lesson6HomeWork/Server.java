package ru.GeekBrains.Lesson6HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final String FINAL_MESSAGE = "\\finish";

    public static void main(String[] args) throws IOException {

        try(ServerSocket serverSocket = new ServerSocket(8081)){
            System.out.println("Создать серверный сокет");
            System.out.println("Ожидаем подключение клиента");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            Runnable taskReadMessageFromConsole = () ->{
                String MessageFromConsole;
                Scanner scanner = new Scanner(System.in);
                do {
                    MessageFromConsole = scanner.nextLine();
                    try {
                        dataOutputStream.writeUTF(MessageFromConsole);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } while(!FINAL_MESSAGE.equals(MessageFromConsole));
                System.out.println("Больше сообщения не отправляются");
            };
            Runnable taskReadMessageFromClient = () ->
                {
                    String MessageFromClient = "";
                    do {
                        try {
                            MessageFromClient = dataInputStream.readUTF();
                            System.out.println("From client: " + MessageFromClient);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } while (!FINAL_MESSAGE.equals(MessageFromClient));
                    System.out.println("Больше сообщения не принимаются");
                };

            new Thread(taskReadMessageFromConsole).start();
            new Thread(taskReadMessageFromClient).start();
            if(!(((Thread)taskReadMessageFromConsole).isAlive() || ((Thread)taskReadMessageFromClient).isAlive())) {
                socket.close();
                System.out.println("Соединение с клиентом разорвано");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
