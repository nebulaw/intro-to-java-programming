package chapter18.exercise07;

import java.util.Scanner;

public class Exercise18_07 {

    public static long count = 0;

    public static long fib(int n) {
        count++;
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = scanner.nextInt();

        System.out.println("Result: " + fib(number));
        System.out.println("Fib function was called " + count + " times");
    }
}
