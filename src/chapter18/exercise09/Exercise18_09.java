package chapter18.exercise09;

import java.util.Scanner;

/**
 * Write a recursive method that displays a string reversely
 * */

public class Exercise18_09 {

    public static void reverseDisplay(String value) {
        if (!value.equals("")) {
            reverseDisplay(value.substring(1));
            System.out.print(value.charAt(0));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        String value = scanner.next();

        reverseDisplay(value);
    }
}
