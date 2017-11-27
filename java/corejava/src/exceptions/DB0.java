package exceptions;

/**
 * Created by aitang on 10/27/17.
 */

import java.util.*;

public class DB0 {
    public static int quotient(int n, int d) {
        return n / d;
    }

    public static void main(String[] args) {
        boolean allOk = false;
        Scanner s = new Scanner(System.in);

        do {
            try {
                System.out.println("Enter n: ");
                int n = s.nextInt();
                System.out.println("Enter d: ");
                int d = s.nextInt();
                System.out.println(quotient(n, d));
                allOk = true;
            } catch (ArithmeticException a) {
                s.nextLine();
                System.out.printf("do again! %s", a);
            } catch (InputMismatchException a) {
                s.nextLine();
                System.out.printf("do again! %s", a);
            }
        } while (allOk == false);
    }
}
