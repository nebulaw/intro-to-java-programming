package chapter13.exercise14;

/**
 * (Demonstrate the benefits of encapsulation) Rewrite the Rational class in
 * Listing 13.13 using a new internal representation for the numerator and denominator.
 * Create an array of two integers as follows:
 *      private long[] r = new long[2];
 * Use r[0] to represent the numerator and r[1] to represent the denominator.
 * The signatures of the methods in the Rational class are not changed, so a client
 * application that uses the previous Rational class can continue to use this new
 * Rational class without being recompiled.
 * */

public class Exercise14 {
  public static void main(String[] args) {
    Rational e = new Rational(1, 3);
    e = e.divide(new Rational(3, 1));
    System.out.println(e);
  }
}
