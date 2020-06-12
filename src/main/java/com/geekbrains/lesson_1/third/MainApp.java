package com.geekbrains.lesson_1.third;

public class MainApp {
    public static void main(String[] args) {
        System.out.println(new Circle(5).area());
        System.out.println(new Square(3, 4).area());
        System.out.println(new Triangle(3, 3, 3).area());
    }
}
