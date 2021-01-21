package ru.GeekBrains.Lesson6HomeWork;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ReadMessageFromConsole extends Thread{
    private static final String FINAL_MESSAGE = "\\finish";
    private DataOutputStream dataOutputStream;
    private Socket socket;

    public ReadMessageFromConsole(Socket socket, String whoAmI) {
        this.socket = socket;
        try {
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println(whoAmI + " готов отправлять сообщения");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
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
        } while (!FINAL_MESSAGE.equals(MessageFromConsole));
        System.out.println("Больше сообщения не отправляются");
    }
}
