package com.aitang;

public class DynGrowQ implements IChar {
    private char[] myQueue;
    private int head;
    private int tail;
    private int size;

    public DynGrowQ() {
        myQueue = new char[2];
        size = 2;
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
            tail++;
        } else {
            size *= 2;
            char[] myNewQueue = new char[size];

            for (int i=head; i<tail; i++) {
                myNewQueue[i-head] = myQueue[head];
            }
            head = 0;
            tail = tail - head;
            myQueue = myNewQueue;
            myQueue[tail] = c;
            tail++;
        }
    }
}
