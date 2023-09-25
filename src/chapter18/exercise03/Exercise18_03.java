package chapter18.exercise03;

import java.util.Scanner;

/**
 * (Compute Greatest Common divisor using recursion) gcd(m, n);
 * */

public class Exercise18_03 {

    public static int gcd(int m, int n) {
        if (m % n == 0)
            return n;
        return gcd(n, m % n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two number: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("GCD: " + gcd(a, b));
    }
}
