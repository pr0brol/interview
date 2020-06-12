package com.geekbrains.lesson_1.third;

public class Square extends Figure {
    private int a;
    private int b;

    public Square(int a, int b) {
        this.a = a;
        this.b = b;
    }

    protected int area() {
        return super.area(a, b);
    }
}
