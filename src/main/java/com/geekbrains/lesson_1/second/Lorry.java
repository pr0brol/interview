package com.geekbrains.lesson_1.second;


//Реализовать абстрактный метод
//реализовать интерфейсы Moveable и Stopable
class Lorry extends Car implements Moveable, Stopable{

    public void move(){
        System.out.println("Car is moving");
    }

    public void stop(){
        System.out.println("Car is stop");
    }


    void open() {

    }
}
