package chapter13.exercise16;

import chapter13.exercise14.Rational;

/**
 * (Create a rational-number calculator) Write a program similar to Listing 7.9,
 * Calculator.java. Instead of using integers, use rationals, as shown in Figure 13.10a.
 * You will need to use the split method in the String class, introduced in
 * Section 10.10.3, Replacing and Splitting Strings, to retrieve the numerator string and
 * denominator string, and convert strings into integers using the Integer.parseInt
 * method.
 * */

public class Exercise16 {

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java expression");
      System.exit(-1);
    }

    String[] tokens = args[0].split(" ");

    Rational lhs, rhs, result = new Rational(0, 1);

    try {
      String[] r1Tokens = tokens[0].split("/");
      if (r1Tokens.length != 2) {
        System.out.println("Invalid operand: " + tokens[0]);
        System.exit(-1);
      }
      String[] r2Tokens = tokens[2].split("/");
      if (r2Tokens.length != 2) {
        System.out.println("Invalid operand: " + tokens[2]);
        System.exit(-1);
      }

      long n1 = Long.parseLong(r1Tokens[0]);
      long d1 = Long.parseLong(r1Tokens[1]);
      long n2 = Long.parseLong(r2Tokens[0]);
      long d2 = Long.parseLong(r2Tokens[1]);

      lhs = new Rational(n1, d1);
      rhs = new Rational(n2, d2);

      switch (tokens[1]) {
        case "+" -> result = lhs.add(rhs);
        case "-" -> result = lhs.subtract(rhs);
        case "/" -> result = lhs.divide(rhs);
        case "*" -> result = lhs.multiply(rhs);
        default  -> {
          System.out.println("Invalid operator: " + tokens[1]);
          System.exit(-1);
        }
      }

      System.out.println(lhs + " " + tokens[1] + " " + rhs + " = " + result);

    } catch (NumberFormatException e) {
      System.out.println("invalid expression: " + args[0]);
      System.exit(-1);
    }

  }
}
