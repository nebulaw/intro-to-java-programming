package chapter13.exercise17;

import java.util.Scanner;

/**
 * (Math: The Complex class) A complex number is a number in the form a + bi,
 * where a and b are real numbers and i is 2 -1. The numbers a and b are known
 * as the real part and imaginary part of the complex number, respectively.
 * */

public class Exercise17 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter the first complex number: ");
    double a = in.nextDouble();
    double b = in.nextDouble();

    System.out.print("Enter the second complex number: ");
    double c = in.nextDouble();
    double d = in.nextDouble();

    Complex c1 = new Complex(a, b);
    Complex c2 = new Complex(c, d);

    System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
    System.out.println(c1 + " - " + c2 + " = " + c1.subtract(c2));
    System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
    System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
    System.out.println("|" + c1 + "| = " + c1.getAbsoluteValue());

  }
}
