package ru.GeekBrains.Lesson1HomeWork;

public abstract class Member implements Jumper,Runner{
    String name;
    protected int canRun;
    protected float canJump;
    public abstract boolean canDoIt(Difficulty diff);

    public String getName() {
        return name;
    }

    public  int canRun(){
        return canRun;
    }

    public  float canJump(){
        return canJump;
    }

}
