package chapter18.exercise17;

import java.util.Scanner;

public class Exercise18_17 {
    public static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    public static int count(char[] chars, char ch, int high) {
        if (high < 0)
            return 0;
        return (chars[high] == ch ? 1 : 0) + count(chars, ch, high - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String value = scanner.next();
        System.out.print("Enter the char: ");
        String ch = scanner.next();

        System.out.println("Count of " + ch + " in " +
                value + " is " + count(value.toCharArray(), ch.charAt(0)));
    }
}
