package chapter12.exercise23;

import java.io.IOException;
import java.net.URI;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        URI uri = URI.create("https://raw.githubusercontent.com/simonseo/schedulinglab/master/random-numbers.txt");
        try {
            Scanner in = new Scanner(uri.toURL().openStream());
            long scoreSum = 0, count = 0;
            while (in.hasNext()) {
                try {
                    long number = in.nextLong();
                    scoreSum += number;
                    count++;
                } catch (NumberFormatException | InputMismatchException e) {
                    System.out.println("skipping non numeric value " + in.next());
                }
            }
            System.out.println("Average is " + ((double)scoreSum / count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
