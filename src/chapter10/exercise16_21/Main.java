package chapter10.exercise16_21;

import chapter10.exercise03.MyInteger;
import chapter10.util.Stack;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;

import static chapter10.exercise03.MyInteger.isPrime;

public class Main {
  public static String[] fivePrimeNumbers() {
    String[] ret = new String[2];
    BigInteger a = new BigInteger(String.valueOf(Long.MAX_VALUE));
    int k = 0;

    while (k < ret.length) {
      if (isPrime(a))
        ret[k++] = a.toString();
      a = a.add(BigInteger.ONE);
    }
    return ret;
  }

  public static int[] MersennePrimeNumbers() {
    Stack stack = new Stack();
    BigInteger initial = new BigInteger("2");

    for (int p = 2; p <= 100; p++)
      if (isPrime(initial.pow(p).subtract(BigInteger.ONE)))
        stack.push(p);
    return stack.toArray();
  }

  public static String[] getNumbers() {
    String[] ret = new String[10];
    BigDecimal initial = new BigDecimal("1.0").scaleByPowerOfTen(50);
    int k = 0;

    while (k < 10) {
      if (initial.remainder(new BigDecimal("2")).equals(BigDecimal.ZERO) ||
          initial.remainder(new BigDecimal("3")).equals(BigDecimal.ZERO))
        ret[k++] = initial.toPlainString();
      initial = initial.add(new BigDecimal("1"));
    }
    return ret;
  }

  public static BigDecimal factorial(long n) {
    BigDecimal result = BigDecimal.ONE;
    for (int i = 1; i <= n; i++)
      result = result.multiply(new BigDecimal("" + i));
    return result;
  }

  public static BigDecimal getApproximationEuler(int n) {
    BigDecimal result = BigDecimal.ONE;
    for (int i = 1; i <= n; i++)
      result = result.add(BigDecimal.ONE.divide(factorial(i), new MathContext(25)));
    return result;
  }

  private static ArrayList<BigInteger> div5or6() {
    BigInteger initial = BigInteger.valueOf(Long.MAX_VALUE);
    ArrayList<BigInteger> result = new ArrayList<>();

    while (result.size() < 10) {
      if (initial.remainder(BigInteger.valueOf(5)).equals(BigInteger.ZERO) ||
          initial.remainder(BigInteger.valueOf(6)).equals(BigInteger.ZERO))
        result.add(initial);
      initial = initial.add(BigInteger.ONE);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("Result: ");
    for (String number : getNumbers())
      System.out.println(number);
    System.out.println();
  }
}
