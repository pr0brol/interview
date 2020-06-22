package com.geekbrains.lesson_3;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainApp {

    public static void main(String[] args) throws InterruptedException {
        PingPongPrinter printer = new PingPongPrinter();

        Thread ping = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printer.printPing();
            }
        });

        Thread pong = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printer.printPong();
            }
        });

        ping.start();
        pong.start();

        ping.join();
        pong.join();

        System.out.println();

        Count count = new Count();
        Lock lock = new ReentrantLock();
        Counter counter = new Counter(count, lock);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("\n" + count.getValue());

    }
}
