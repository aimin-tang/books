package com.aitang;

import java.io.*;

public class Main {

    public static void main(String[] args)
        throws IOException
    {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    String str;
	    int n;
	    double sum=0.0;
	    double avg, t;

        System.out.println("How many numbers will you enter: ");
        str = br.readLine();

        n = Integer.parseInt(str);

        System.out.println("Enter " + n + " values.");
        for (int i=0; i<n; i++) {
            System.out.println(": ");
            str = br.readLine();
            t = Double.parseDouble(str);
            sum += t;
        }

        avg = sum / n;
        System.out.println("Average is: " + avg);
    }
}
