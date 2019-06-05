package com.aitang;

public class Main {

    public static void main(String[] args) {
        MyQueue testQueue = new MyQueue(3);
        testQueue.put(1);
        testQueue.put(1);
        testQueue.put(1);
        testQueue.put(1);
        Object r = testQueue.get();
        r = testQueue.get();
        System.out.println(r);
        r = testQueue.get();
        r = testQueue.get();
        System.out.println(r);
    }
}
