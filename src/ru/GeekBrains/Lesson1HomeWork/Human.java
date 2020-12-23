package ru.GeekBrains.Lesson1HomeWork;

import java.util.Random;

public class Human extends Humanity {
    private Random random = new Random();


    public Human(String name, int canRun, float canJump) {
        this.name = name;
        this.canRun = canRun;
        this.canJump = canJump;
    }

    public Human(String name) {
        this.name = name;
        this.canRun = random.nextInt(100) + 150;
        this.canJump = 0.5f + 1.5f * random.nextFloat();
    }

    @Override
    public boolean jump(float height) {
        return true;
    }

    @Override
    public boolean run(int length) {
        return true;
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
