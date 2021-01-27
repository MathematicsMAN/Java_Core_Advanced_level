package ru.GeekBrains.Lesson7HomeWork.client;


import ru.GeekBrains.Lesson7HomeWork.server.Message;

public interface ServerService {

    String openConnection(String login,String password);
    void closeConnection();

    void sendMessage(String message);
    Message readMessages();

}
