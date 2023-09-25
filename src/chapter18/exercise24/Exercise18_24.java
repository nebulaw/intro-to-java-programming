package chapter18.exercise24;

import java.util.Scanner;

public class Exercise18_24 {
    public static int hex2Dec(String hex) {
        return hex2Dec(hex, 0, hex.length() - 1);
    }

    public static int hex2Dec(String hex, int left, int right) {
        if (right < left)
            return 0;
        else return (Character.isDigit(hex.charAt(right)) ?
                    hex.charAt(right) - 48 :
                    hex.charAt(right) - 55) + 16 * hex2Dec(hex, left, right - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the hex number: ");
        String bin = in.next();

        System.out.println("Decimal: " + hex2Dec(bin));
    }
}
