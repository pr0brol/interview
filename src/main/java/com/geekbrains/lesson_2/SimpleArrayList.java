package com.geekbrains.lesson_2;

import java.util.Arrays;

public class SimpleArrayList<T> {
    private final int CAPACITY = 10;
    private int size = 0;
    private final Object[] DEFAULT_ARRAY = {};
    private T[] data;

    public SimpleArrayList() {
        data = (T[]) new Object[CAPACITY];
    }

    public SimpleArrayList(T[] array) {
        data = array;
        size = array.length;
    }

    public void add(T obj){
        size++;
        if(size >= data.length){
            data = Arrays.copyOf(data, size * 2);
        }
        data[size - 1] = obj;
    }

    public T get(int index){
        if(index >= 0 && index < size){
            return data[index];
        }else {
            return null;
        }
    }

    public boolean remove(T obj){
        for (int i=0;i<size;i++){
            if(data[i].equals(obj)){
                return remove(i);
            }
        }
        return false;
    }

    public boolean remove(int index){
        if(index < 0 || index > size){
            return false;
        }
        System.arraycopy(data, index+1, data, index, size-index-1);
        size--;
        return true;
    }

    public int size(){
        return size;
    }

    public void clear(){
        data = (T[]) DEFAULT_ARRAY;
        size=0;
    }

}
