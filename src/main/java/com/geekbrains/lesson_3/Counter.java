package com.geekbrains.lesson_3;

import java.util.concurrent.locks.Lock;

public class Counter {

    private Count count;
    Lock lock;

    public Counter(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    public void increment() {
        lock.lock();
        try {
            count.setValue(count.getValue() + 1);
        } finally {
            lock.unlock();
        }
    }
}