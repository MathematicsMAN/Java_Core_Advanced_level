package ru.GeekBrains.Lesson3HomeWork;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap book;

    public PhoneBook() {
        this.book = new HashMap<Integer,String>();
    }

    public void add(Integer phoneNumber, String surname) {
        book.put(phoneNumber,surname);
    }

    public HashSet<Integer> get(String surname) {
        final HashSet<Integer> phones = new HashSet<>();

        book.forEach((k,v)->{
            if(surname.equals(v)) {
//                System.out.println("phone: " + k + "\t name:\t" + v);
                phones.add((Integer) k);
            }
        });
        if(phones.isEmpty()){
            System.out.println("Фамилии " + surname + " нет в телефонной книге");
            return null;
        } else return phones;
    }
}
