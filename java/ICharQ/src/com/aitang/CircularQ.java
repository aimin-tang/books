package com.aitang;

public class CircularQ implements IChar {
    char[] myQueue;
    int head;
    int tail;
    boolean wrapping;

    public CircularQ(int size) {
        myQueue = new char[size];
        head = 0;
        tail = 0;
        wrapping = false;
    }

    @Override
    public char get() {
        if (wrapping) {
            if (head < myQueue.length) {
                char result = myQueue[head];
                head++;
                return result;
            } else {
                if (tail > 0) {
                    head = 1;
                    wrapping = false;
                    return myQueue[0];
                } else {
                    System.out.println("Cannot get: if/else/else");
                    return 0;
                }
            }
        } else {
            if (head < tail) {
                char result = myQueue[head];
                head++;
                return result;
            } else {
                System.out.println("Cannot get: else/else");
                return 0;
            }
        }
    }

    @Override
    public void put(char c) {
        if (wrapping) {
            if (tail < head) {
                myQueue[tail] = c;
                tail++;
            } else {
                System.out.println("Cannot put: if/else");
            }
        } else {
            if (tail < myQueue.length) {
                myQueue[tail] = c;
                tail++;
            } else {
                if (head > 0) {
                    myQueue[0] = c;
                    tail = 1;
                    wrapping = true;
                } else {
                    System.out.println("Cannot put: else/else/else");
                }
            }
        }
    }
}
