package chapter18.exercise22;

import java.util.Scanner;

public class Exercise18_22 {
    public static char digit2hex(int digit) {
        return switch (digit) {
            case 10 -> 'A';
            case 11 -> 'B';
            case 12 -> 'C';
            case 13 -> 'D';
            case 14 -> 'E';
            case 15 -> 'F';
            default -> (char)(digit + 48);
        };
    }

    public static String dec2hex(int value) {
        if (value <= 0)
            return "";
        return dec2hex(value / 16) + digit2hex(value % 16);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the decimal number: ");
        int dec = in.nextInt();

        System.out.println("Hex: " + dec2hex(dec));
    }
}
