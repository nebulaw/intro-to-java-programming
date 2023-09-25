package chapter13.exercise15;

import java.math.BigInteger;

/**
 * (Use BigInteger for the Rational class) Redesign and implement the
 * Rational class in Listing 13.13 using BigInteger for the numerator and
 * denominator.
 * */

public class Exercise15 {
  public static void main(String[] args) {
    RationalBI f1 = new RationalBI(BigInteger.valueOf(124124), BigInteger.valueOf(214400));
    RationalBI f2 = new RationalBI(BigInteger.valueOf(214425), BigInteger.valueOf(42444));

    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f1.divide(f2));
  }
}
