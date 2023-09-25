package chapter18.exercise23;

import java.util.Scanner;

public class Exercise18_23 {
    public static int bin2Dec(String binaryString) {
        return bin2Dec(new StringBuilder(binaryString).reverse().toString(), 0);
    }

    public static int bin2Dec(String bin, int left) {
        if (left == bin.length())
            return 0;
        return (bin.charAt(left) == '1' ? (int)Math.pow(2, left) : 0) + bin2Dec(bin, left + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the binary number: ");
        String bin = in.next();

        System.out.println("Decimal: " + bin2Dec(bin));
    }
}
