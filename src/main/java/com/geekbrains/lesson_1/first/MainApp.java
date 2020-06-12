package com.geekbrains.lesson_1.first;

public class MainApp {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .setFirstName("Bob")
                .setLastName("Jonson")
                .setMiddleName("Parker")
                .setCountry("Russia")
                .setAddress("Moscow")
                .setPhone("5-55-55")
                .setAge(15)
                .setGender("man")
                .build();

        System.out.println(person.toString());
    }
}
