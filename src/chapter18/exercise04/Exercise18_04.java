package chapter18.exercise04;


import java.util.Scanner;

/**
 * 1 +  1/2 + 1/3 + ... +  1/i
 * */

public class Exercise18_04 {

    public static double findSeries(int i) {
        return findSeriesTr(i, 0);
    }

    public static double findSeriesTr(int i, double result) {
        if (i == 0)
            return result;
        return findSeriesTr(i - 1, result + 1.0 / i);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int i = in.nextInt();

        System.out.println("Result: " + findSeries(i));
    }

}
