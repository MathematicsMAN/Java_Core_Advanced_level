package ru.GeekBrains.Lesson7HomeWork.client;

public class ClientApp {
    public static void main(String[] args) {
        new MyClient("ivan", "password").setVisible(true);
        new MyClient("sharik", "gav").setVisible(true);
    }
}
