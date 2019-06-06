package com.aitang;

public class Main {

    public static void main(String[] args) {
	    char[] a = {'d', 'x', 'a', 'r'};
	    int i;

	    for (char c: a) {
            System.out.print(c);
        }
        System.out.println();
	    Quicksort.qsort(a);
        for (char c: a) {
            System.out.print(c);
        }

        System.out.println();
        System.out.println(avg(1, 2, 3, 4));
        System.out.println(avg(1, 2, 3));
        System.out.println(avg());
    }

    static int avg(int ... ints) {
        int sum = 0;
        for (int i: ints) sum += i;
        if (ints.length == 0) return 0;
        return sum / ints.length;
    }
}

class Quicksort {
    static void qsort(char[] items) {
        qs(items, 0, items.length-1);
    }

    private static void qs(char[] items, int left, int right) {
        int i, j;
        char x, y;
        i = left;
        j = right;
        x = items[(left + right) / 2];

        do {
            while ((items[i] < x) && (i < right)) i++;
            while ((x < items[j]) && (j > left)) j--;

            if (i <= j) {
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++; j--;
            }
        } while (i <= j);

        if (left < j) qs(items, left, j);
        if (i < right) qs(items, i, right);
    }
}