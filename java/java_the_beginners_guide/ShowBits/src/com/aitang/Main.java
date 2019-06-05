package com.aitang;

public class Main {

    public static void main(String[] args) {
	    if (args.length != 1) {
            System.out.println("Args: positive number");
        } else {
	        int num = Integer.parseInt(args[0]);
	        if (num < 0) {
                System.out.println("has to be positive");
            } else {
	            String result = "";
	            while (num >= 1) {
	                int remainder = num % 2;
	                result = remainder + result;
	                num = num / 2;
                }
                System.out.println("result is: " + result);
            }
        }
    }
}
