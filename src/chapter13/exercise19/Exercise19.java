package chapter13.exercise19;

import chapter13.exercise14.Rational;

import java.util.Scanner;

/**
 * (Convert decimals to fractions) Write a program that prompts the user to enter
 * a decimal number and displays the number in a fraction. Hint: read the decimal
 * number as a string, extract the integer part and fractional part from the String.
 * */

public class Exercise19 {
  private static final long MAX_CYCLES = 1_000_000;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter a decimal number: ");
    String decimalNumber = in.next();

    long n = (long)(Double.parseDouble(decimalNumber) *
        Math.pow(10, countDecimals(decimalNumber)));
    long d = (long)(Math.pow(10, countDecimals(decimalNumber)));

    System.out.println("The fraction number is " + (new Rational(n, d)));

  }

  public static long countDecimals(String decimalNumber) {
    return decimalNumber.length() - 1 - decimalNumber.indexOf('.');
  }

}
