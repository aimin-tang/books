package com.aitang;

public class Main {

    public static void main(String[] args) {
        C c = new C();
        C.x = 5;
        System.out.println(c.x);
        System.out.println(C.x);
    }


}

class C {
    static int x;
}
