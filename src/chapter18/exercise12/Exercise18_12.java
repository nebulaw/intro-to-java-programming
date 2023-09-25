package chapter18.exercise12;

import java.util.Scanner;

/**
 * (Print the characters in a string reversely) Rewrite Programming Exercise 18.9
 * using a helper method to pass the substring high index to the method
 * */

public class Exercise18_12 {

    public static void reverseDisplay(String value, int high) {
        if (high < 0) {
            System.out.println();
            return;
        }
        System.out.print(value.charAt(high));
        reverseDisplay(value, high - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String value = scanner.next();

        reverseDisplay(value, value.length() - 1);
    }
}
