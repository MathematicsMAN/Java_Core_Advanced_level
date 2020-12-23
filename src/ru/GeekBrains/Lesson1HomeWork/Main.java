package ru.GeekBrains.Lesson1HomeWork;

import java.util.Random;

public class Main {
    static final int MAX_MEMBERS = 10;
    static final int MAX_DIFFICULTS = 5;
    static Random random = new Random();

    static Member[] members = new Member[MAX_MEMBERS];
    static Difficulty[] difficulty = new Difficulty[MAX_DIFFICULTS];
    
    public static void main(String[] args) {

        initializeMembers();
        initializeDifficult();

        System.out.println("---------Начинаем бег с препятствиями:");
        for (Member member: members) {
            for (Difficulty diff : difficulty) {
                if(!member.canDoIt(diff)){
                    System.out.println(member.getName() + " не может  " + diff.getDiff());
                    break;
                } else {
                    System.out.println(member.getName() + " может " + diff.getDiff());
                }
            }
        }
    }

    private static void initializeMembers() {
        System.out.println("------Участники: --------------");
        for (int i = 0, j = 0, k = 0; i + j + k < MAX_MEMBERS;) {
            switch (random.nextInt(3)){
                case 0 -> members[i + j + k] = new Human("Человек " + ++i + "-й");
                case 1 -> members[i + j + k] = new Cat("Кот " + ++j + "-й");
                case 2 -> members[i + j + k] = new Robot("Робот " + ++k + "-й");
            }
            System.out.printf("%s может пробежать %d, может прыгнуть на %.2f%n",
                    members[i + j + k - 1].getName(), members[i + j + k - 1].canRun,
                    members[i + j + k - 1].canJump);
        }
    }

    private static void initializeDifficult() {
        System.out.println("------Препятствия: --------------");
        for (int i = 0, j = 0; i + j < MAX_DIFFICULTS;) {
            switch (random.nextInt(2)) {
                case 0 -> difficulty[i + j] = new Track("Дорожка " + ++i + "-я");
                case 1 -> difficulty[i + j] = new Wall("Стена " + ++j + "-я");
            }
            System.out.print(difficulty[i + j - 1].getName());
            if(difficulty[i + j - 1] instanceof Track){
                System.out.println(" в длину " + ((Track)difficulty[i + j - 1]).getLength());
            }else if(difficulty[i + j - 1] instanceof Wall){
                System.out.printf(" в высоту %.2f%n", ((Wall)difficulty[i + j - 1]).getHeight());
            }
        }
    }
}
