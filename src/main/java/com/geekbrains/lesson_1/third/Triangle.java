package com.geekbrains.lesson_1.third;

public class Triangle extends Figure{
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        return super.area(a, b, c);
    }
}
