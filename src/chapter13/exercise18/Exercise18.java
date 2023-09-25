package chapter13.exercise18;

import chapter13.exercise15.RationalBI;

import java.math.BigInteger;

/**
 * Write a program
 * that computes the following summation series
 * using the Rational class:
 * 1/2 + 2/3 + 3/4 + ... + 98/99 + 99/100
 * */

public class Exercise18 {
  public static void main(String[] args) {
    RationalBI seriesResult = new RationalBI();

    for (int i = 1; i < 20; i++)
      seriesResult = seriesResult.add(
          new RationalBI(BigInteger.valueOf(i), BigInteger.valueOf(i+1)));
    System.out.println("Result is " + seriesResult);
  }
}
