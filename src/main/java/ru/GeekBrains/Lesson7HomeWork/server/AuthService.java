package ru.GeekBrains.Lesson7HomeWork.server;

public interface AuthService {
    void start();
    void stop();
    String getNickByLoginAndPass(String login, String password);
}
