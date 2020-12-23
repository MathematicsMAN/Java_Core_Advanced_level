package ru.GeekBrains.Lesson1HomeWork;

import java.util.Random;

public class Cat extends Animal{
    private Random random = new Random();

    public Cat(String name, float canJump, int canRun) {
        this.name = name;
        this.canJump = canJump;
        this.canRun = canRun;
    }

    public Cat(String name) {
        this.name = name;
        canRun = random.nextInt(100) + 50;
        canJump = 1.0f + 1.5f * random.nextFloat();
    }

    @Override
    public boolean jump(float height) {
        return false;
    }

    @Override
    public boolean run(int length) {
        return false;
    }

    @Override
    public boolean canDoIt(Difficulty diff) {
        if (diff instanceof Wall){
            return canJump >= ((Wall)diff).getHeight();
        } else if(diff instanceof Track){
            return canRun >= ((Track)diff).getLength();
        }
        return false;
    }
}
