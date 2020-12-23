package ru.GeekBrains.Lesson1HomeWork;

import java.util.Random;

public class Track extends Difficulty{
    private final int length;
    private Random random = new Random();

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Track(String name) {
        this.name = name;
        this.length = random.nextInt(100) + 100;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getDiff() {
        return "пробежать " + length + "м";
    }
}
