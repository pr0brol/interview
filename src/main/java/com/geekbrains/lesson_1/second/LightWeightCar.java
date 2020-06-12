package com.geekbrains.lesson_1.second;

class LightWeightCar extends Car implements Moveable{

    //@Override
    //реализация
    void open() {
        System.out.println("Car is open");
    }

    //@Override
    //реализация, не переопределение
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    //этот можно переопределить, есть реализация в родителе
    protected void start() {
        super.start();
    }
}
