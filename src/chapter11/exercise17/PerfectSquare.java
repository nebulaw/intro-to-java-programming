package chapter11.exercise17;

import java.util.Scanner;

public class PerfectSquare {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter m: ");
    int m = scanner.nextInt();
    int n = m;

    for (int i = (int)Math.sqrt(m); i < Integer.MAX_VALUE; i++)
      if (i * i % m == 0) {
        n = i * i / m;
        break;
      }

    System.out.println("Result: m * n = " + (m * n) + " where n is " + n);

  }
}
