package chapter18.exercise05;


import java.util.Scanner;

/**
 * 1/3 + 2/5 + 3/7 + 4/9 + ... + i / (2i + 1)
 * */

public class Exercise18_05 {

    public static double findSeries(int i) {
        return findSeriesTr(i, 0);
    }

    public static double findSeriesTr(int i, double result) {
        if (i == 0)
            return result;
        return findSeriesTr(i - 1, result + (double)i / (2 * i + 1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int i = in.nextInt();

        System.out.println("Result: " + findSeries(i));
    }
}
