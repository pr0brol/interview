package com.geekbrains.lesson_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Integer> numList = new LinkedList<>();
        numList.add(1);
        numList.add(3);
        numList.add(2);
        numList.add(6);
        numList.add(4);
        numList.add(7);
        Iterator<Integer> iterator = numList.listIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("size before remove: " + numList.size());
        System.out.println(numList.remove(2));
        System.out.println("size after remove: " + numList.size());
        System.out.println("index of number 7: " + numList.indexOf(7));
        System.out.println("list contains number 6: " + numList.contains(6));
        numList.clear();
        System.out.println("size after clear: " + numList.size());
        System.out.println();


        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("fore");
        stringList.add("five");
        stringList.add("six");
        stringList.add("seven");
        stringList.stream().forEach(s -> System.out.print(s + " "));
        stringList = stringList.subList(2, stringList.size());
        System.out.println();
        stringList.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println(stringList.get(3));
        System.out.println(stringList.isEmpty());

    }
}
