package ru.GeekBrains.Lesson1HomeWork;

import java.util.Random;

public class Wall extends Difficulty{
    private final float height;
    private Random random = new Random();

    public Wall(String name, float height) {
        this.name = name;
        this.height = height;
    }

    public Wall(String name) {
        this.name = name;
        this.height = 1 + 2 * random.nextFloat();
    }

    public float getHeight() {
        return height;
    }

    @Override
    String getDiff() {
        return String.format("перепрыгнуть %.2f м",height);
    }
}
