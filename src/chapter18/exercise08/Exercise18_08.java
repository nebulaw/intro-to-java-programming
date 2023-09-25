package chapter18.exercise08;

import java.util.Scanner;

/**
 * Write a recursive method that displays an int value reversely
 * */

public class Exercise18_08 {

    public static void reverseDisplay(int value) {
        if (value <= 0) {
            System.out.println();
            return;
        }
        System.out.print(value % 10);
        reverseDisplay(value / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = scanner.nextInt();

        reverseDisplay(number);
    }

}
