package ru.GeekBrains.Lesson1HomeWork;

import java.util.Random;

public class Robot extends Technic{
    private Random random = new Random();

    public Robot(String name, int canRun, float canJump) {
        this.name = name;
        this.canRun = canRun;
        this.canJump = canJump;
    }

    public Robot(String name) {
        this.name = name;
        this.canJump = 0.5f + 1.5f * random.nextFloat();
        this.canRun = random.nextInt(100) + 250;
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
