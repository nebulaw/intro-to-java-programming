package chapter18.exercise02;


import java.util.Scanner;

/**
 * (Fibonacci numbers) Rewrite the fib method in Listing 18.2 using iterations.
 * Hint: To compute fib(n) without recursion, you need to obtain fib(n - 2)
 * and fib(n - 1) first.
 * */

public class Exercise18_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = scanner.nextInt();

        long f0 = 0;
        long f1 = 1;

        for (int i = 1; i <= number; i++) {
            long f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }

        System.out.println("Your fibonacci number is " + f1);

    }
}
