package chapter19.exercise02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise19_02 {
    public static void main(String[] args) {
        GenericStack<String> lines = new GenericStack<>(2);
        Scanner in = new Scanner(System.in);

        System.out.print("Enter 5 strings: ");
        for (int i = 0; i < 5; i++)
            lines.add(in.next());

        System.out.println("Reversed: ");
        for (int i = 0; i < 5; i++)
            System.out.print(lines.pop());
        System.out.println();
    }
}
