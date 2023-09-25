package chapter18.exercise10;

import java.util.Scanner;

public class Exercise18_10 {

    public static int count(String str, char a) {
        if (str.equals(""))
            return 0;
        return (str.charAt(0) == a ? 1 : 0) + count(str.substring(1), a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String value = scanner.next();
        System.out.print("Enter the char: ");
        String ch = scanner.next();

        System.out.println("Number of occurrences: " + count(value, ch.charAt(0)));
    }

}
