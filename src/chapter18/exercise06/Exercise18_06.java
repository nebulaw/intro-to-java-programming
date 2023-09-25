package chapter18.exercise06;

import java.util.Scanner;

/**
 * 1/2 + ... + i / i + 1
 * */

public class Exercise18_06 {
    public static double findSeries(int i) {
        return findSeriesTr(i, 0);
    }

    public static double findSeriesTr(int i, double result) {
        if (i == 0)
            return result;
        return findSeriesTr(i - 1, result + (double)i / (i + 1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int i = in.nextInt();

        System.out.println("Result: " + findSeries(i));
    }
}
