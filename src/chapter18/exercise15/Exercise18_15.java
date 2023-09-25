package chapter18.exercise15;

import java.util.Scanner;

public class Exercise18_15 {

    public static int count(String value, char a) {
        return count(value, a, value.length() - 1);
    }

    public static int count(String value, char a, int high) {
        if (high < 0)
            return 0;
        return (value.charAt(high) == a ? 1 : 0) + count(value, a, high - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String value = scanner.next();
        System.out.print("Enter the char: ");
        String ch = scanner.next();

        System.out.println("Count of " + ch + " in " + value + " is " + count(value, ch.charAt(0)));
    }
}
