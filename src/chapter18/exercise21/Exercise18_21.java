package chapter18.exercise21;

import java.util.Scanner;

/**
 * Recursive dec2bin(int value)
 * */

public class Exercise18_21 {
    public static String dec2bin(int value) {
        if (value <= 0)
            return "";
        return dec2bin(value / 2) + value % 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the decimal number: ");
        int dec = in.nextInt();

        System.out.println("Binary: " + dec2bin(dec));
    }
}
