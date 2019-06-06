package com.aitang;

public class Main {

    public static void main(String[] args) {

        // Linear Queue
	    LinearQ lq = new LinearQ(3);
	    lq.put('a');
	    lq.put('b');
	    lq.put('c');
	    lq.put('d');
        System.out.println("" + lq.get());
        System.out.println("" + lq.get());
        System.out.println("" + lq.get());
        System.out.println("" + lq.get());

        System.out.println("==================");

        // Circular Queue
        CircularQ cq = new CircularQ(3);
        cq.put('a');
        cq.put('b');
        cq.put('c');
        cq.put('d');
        System.out.println("" + cq.get());
        System.out.println("" + cq.get());
        System.out.println("" + cq.get());
        System.out.println("" + cq.get());

        System.out.println("==================");

        cq = new CircularQ(3);
        cq.put('a');
        System.out.println("" + cq.get());
        cq.put('b');
        System.out.println("" + cq.get());
        cq.put('c');
        System.out.println("" + cq.get());
        cq.put('d');
        System.out.println("" + cq.get());
    }
}
