package com.geekbrains.lesson_3;

public class PingPongPrinter {
    boolean flag = false;

    synchronized void printPong() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.print("Pong ");
        flag = false;
        notify();
    }

    synchronized void printPing() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("Ping ");
        flag = true;
        notify();
    }
}

