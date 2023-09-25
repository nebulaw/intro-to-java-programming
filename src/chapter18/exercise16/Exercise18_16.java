package chapter18.exercise16;

import java.util.Scanner;

/**
 * counting upper cases
 * */

public class Exercise18_16 {
    public static int count(char[] chars) {
        return count(chars, chars.length - 1);
    }

    public static int count(char[] chars, int high) {
        if (high < 0)
            return 0;
        return (Character.isUpperCase(chars[high]) ? 1 : 0) + count(chars, high - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String value = scanner.next();

        System.out.println("Count of upper case letters is " + count(value.toCharArray()));
    }
}
