package com.aitang;

public class LinearQ implements IChar {
    private char[] myQueue;
    private int head;
    private int tail;

    public LinearQ(int size) {
        myQueue = new char[size];
        head = 0;
        tail = 0;
    }

    @Override
    public char get() {
        if (head < tail) {
            char result = myQueue[head];
            head++;
            return result;
        } else {
            System.out.println("Cannot get");
            return 0;
        }
    }

    @Override
    public void put(char c) {
        if (tail < myQueue.length) {
            myQueue[tail] = c;
            tail ++;
        } else {
            System.out.println("Cannot put");
        }
    }
}
