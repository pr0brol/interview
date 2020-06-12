package com.geekbrains.lesson_1.third;

public abstract class Figure {
    protected int area(int a, int b) {
        return a * b;
    }

    protected double area(int r) {
        return Math.PI * r * r;
    }

    protected double area(int a, int b, int c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
