package ru.GeekBrains.Lesson2HomeWork;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(int i, int j, NumberFormatException e) {
        super("Содержимое ячейки [" + i + "][" + j + "] - не является числом", e);
    }

}
