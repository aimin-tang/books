package com.aitang;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	    int i;
	    FileInputStream fin;

	    if (args.length != 1) {
            System.out.println("Usage: io file");
            return;
        }

        fin = new FileInputStream(args[0]);
    }
}
