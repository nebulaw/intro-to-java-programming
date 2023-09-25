package chapter12.exercise02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String invalid = "";
    String lhsStr, rhsStr;
    int lhs, rhs;

    try {
      System.out.print("Enter two numbers: ");
      lhs = scanner.nextInt();
      rhs = scanner.nextInt();
      int sum = lhs + rhs;
      System.out.println("Sum: " + sum);
    } catch (InputMismatchException e) {
      System.out.println("Invalid operand");
    }

  }
}
