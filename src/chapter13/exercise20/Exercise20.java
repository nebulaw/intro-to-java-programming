package chapter13.exercise20;

import chapter13.exercise17.Complex;

import java.util.Scanner;

/**
 * (Algebra: solve quadratic equations) Rewrite Programming Exercise 3.1 to obtain
 * imaginary roots if the determinant is less than 0 using the Complex class in
 * Programming Exercise 13.17
 * */

public class Exercise20 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter a, b, c: ");
    double a = in.nextDouble();
    double b = in.nextDouble();
    double c = in.nextDouble();

    double d = b * b - 4 * a * c;

    if (d > 0) {
      double root1 = (-b + Math.sqrt(d)) / (2 * a);
      double root2 = (-b - Math.sqrt(d)) / (2 * a);
      System.out.println("The roots are " + root1 + " and " + root2);
    } else if (d == 0) {
      double root = -b / (2 * a);
      System.out.println("The root is " + root);
    } else {
      double realPart = -b / (2 * a);
      double imaginaryPart = Math.sqrt(-d) / (2 * a);
      Complex root1 = new Complex(realPart, imaginaryPart);
      Complex root2 = new Complex(realPart, -imaginaryPart);
      System.out.println("The roots are " + root1 + " and " + root2);
    }
  }
}
