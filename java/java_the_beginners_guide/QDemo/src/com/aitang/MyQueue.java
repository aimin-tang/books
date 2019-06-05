package com.aitang;

public class MyQueue {
    private Object[] my_queue;
    int head;
    int tail;
    int size;

    public MyQueue(int size) {
        this.size = size;
        head = 0;
        tail = 0;
        my_queue = new Object[size];
    }

    void put(Object o) {
        if (tail >= size) {
            System.out.println("Cannot put");
        } else {
            my_queue[tail] = o;
            tail++;
        }
    }

    Object get() {
        if (tail > head) {
            Object r = my_queue[head];
            head++;
            return r;
        } else {
            System.out.println("Cannot get");
            return null;
        }
    }
}
