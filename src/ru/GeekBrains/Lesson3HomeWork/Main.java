package ru.GeekBrains.Lesson3HomeWork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("//---------PART ONE----------//");
        String[] words = {"one","two","three","four","five",
                "two","three","four","five", "six",
                "three","four","five","six","seven",
                "ten","nine","eight","seven","six"};
        HashMap<String, Integer> countWords = new HashMap<>();

        for (String word : words) {
            countWords.putIfAbsent(word, 0);
            countWords.put(word,countWords.get(word) + 1);
//            System.out.println(countWords);
        }
        countWords.forEach((k,v)->System.out.printf("Слово '%s' встречается %d раз(а)%n",k,v));

        System.out.println("\n//---------PART TWO----------//");
        final int NUMBER_PHONES = 20;
        final int NUMBER_NAMES = 15;
        final int START_PHONE_NUMBER = 10_000_000;
        PhoneBook phBook = new PhoneBook();
        Random random = new Random();
        HashSet<Integer> phones;

        for (int i = 0; i < NUMBER_PHONES; i++) {
            phBook.add(START_PHONE_NUMBER + i,
                    "Name" + random.nextInt(NUMBER_NAMES));
        }
        for (int i = 0; i < NUMBER_NAMES; i++) {
            System.out.println("Поиск номеров телефона по фамилии: Name" + i);
            phones = phBook.get("Name" + i);
            if(phones != null) {
                System.out.println("Телефонные номера: " + phones);
            }
        }
    }
}
