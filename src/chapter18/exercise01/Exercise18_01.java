package chapter18.exercise01;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * (Factorial) Using the BigInteger class introduced in Section 10.9, you can
 * find the factorial for a large number (e.g., 100!). Implement the factorial
 * method using recursion. Write a program that prompts the user to enter an
 * integer and displays its factorial
 * */

public class Exercise18_01 {

    public static BigInteger factorial(BigInteger n) {
        return factorial_tail(n, BigInteger.ONE);
    }

    public static BigInteger factorial_tail(BigInteger n, BigInteger result) {
        if (n.equals(BigInteger.ZERO))
            return result;
        return factorial_tail(n.subtract(BigInteger.ONE), n.multiply(result));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        String number = scanner.next();

        System.out.println("Factorial is " + factorial(new BigInteger(number)));
    }
}
