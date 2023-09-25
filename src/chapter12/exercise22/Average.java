package chapter12.exercise22;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

/**
 * (Process scores in a text file on the Web) Suppose that the text file on the
 * *12.24
 * Web https://raw.githubusercontent.com/simonseo/schedulinglab/master/random-numbers.txt contains an unspecified number
 * of scores. Write a program that reads the scores from the file and displays their
 * total and average. Scores are separated by blanks.
 * */

public class Average {
  public static void main(String[] args) {
    URI uri = URI.create("https://raw.githubusercontent.com/simonseo/schedulinglab/master/random-numbers.txt");
    try {
      Scanner in = new Scanner(uri.toURL().openStream());
      int sum = 0, count = 0;
      while (in.hasNext()) {
        try {
          int number = in.nextInt();
          sum += number;
          count++;
        } catch (NumberFormatException e) {
          System.out.println("skipping non numeric value " + in.next());
        }
      }
      System.out.println("Average is " + ((double)sum / count));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
