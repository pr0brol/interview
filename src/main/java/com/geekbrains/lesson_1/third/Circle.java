package com.geekbrains.lesson_1.third;

public class Circle extends Figure {
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    protected double area() {
        return super.area(r);
    }
}
