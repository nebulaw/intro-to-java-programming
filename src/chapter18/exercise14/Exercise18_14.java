package chapter18.exercise14;

import java.util.Scanner;

public class Exercise18_14 {
    public static int countUppercase(String value) {
        if (value.length() == 0)
            return 0;
        return (Character.isUpperCase(value.charAt(0)) ? 1 : 0) +
                countUppercase(value.substring(1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String value = scanner.next();

        System.out.println("Upper Cases are " + countUppercase(value));
    }
}
