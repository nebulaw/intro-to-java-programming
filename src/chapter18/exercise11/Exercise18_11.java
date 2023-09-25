package chapter18.exercise11;

import java.util.Scanner;

public class Exercise18_11 {

    public static int sumDigits(long n) {
        if (n < 1)
            return (int)n;
        return (int)(n % 10 + sumDigits(n / 10));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        long value = scanner.nextLong();

        System.out.println("Sum of digits: " + sumDigits(value));
    }
}
