package ru.GeekBrains.Lesson2HomeWork;

public class MyArraySizeException extends Exception{
    public MyArraySizeException(String s) {
        super(s);
    }

    public MyArraySizeException(int N) {
        this("Высота матрицы не равна " + N);
    }

    public MyArraySizeException(int i, int N) {
        this("Ширина " + i + "-го" + " столбца матрицы не равна " + N);
    }
}