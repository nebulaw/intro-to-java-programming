package chapter18.exercise25;

import java.util.Scanner;

public class Exercise18_25 {
    public static void displayPermutations(String s) {
        displayPermutations("", s);
    }

    public static void displayPermutations(String s1, String s2) {
        if (s2.isEmpty())
            System.out.println(s1);
        else {
            for (int i = 0; i < s2.length(); i++)
                displayPermutations(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter string: ");
        String value = in.next();

        displayPermutations(value);
    }
}
