package chapter12.exercise14;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("invalid numbers of arguments");
      System.exit(-1);
    }

    File file = new File(args[0]);

    if (!file.exists()) {
      System.out.println("file was not found.");
      System.exit(-1);
    }

    try (
      Scanner in = new Scanner(file);
    ) {
      int sum = 0, count = 0;
      while (in.hasNext()) {
        try {
          int number = in.nextInt();
          sum += number;
          count++;
        } catch (InputMismatchException e) {
          System.out.println("skipping non numeric value " + in.next());
        }
      }
      System.out.println("Average is " + ((double)sum / count));
    } catch (IOException e) {
      System.out.println("error reading file");
    }


  }
}
