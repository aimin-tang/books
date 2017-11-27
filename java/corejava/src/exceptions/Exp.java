package exceptions;
import java.util.Scanner;

/**
 * Created by aitang on 10/27/17.
 */
public class Exp {
    public static int quotient(int n, int d) {
        return n / d;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the numerator: ");
        int n = s.nextInt();
        System.out.println("Enter the denominator: ");
        int d = s.nextInt();

        int result = quotient(n, d);
        System.out.println(result);
    }
}
