package chapter10.exercise03;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;

public class MyInteger {
  private int value;

  public MyInteger() {
    value = 0;
  }

  public MyInteger(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public boolean isEven() { return value % 2 == 0; }

  public boolean isOdd() { return value % 2 == 1; }

  public boolean isPrime() {
    return MyInteger.countDivisors(this.value) == 2;
  }

  public static boolean isEven(int value) {
    return value % 2 == 0;
  }

  public static boolean isEven(MyInteger value) {
    return value.isEven();
  }

  public static boolean isOdd(int value) {
    return value % 2 == 1; // !isEven();
  }

  public static boolean isOdd(MyInteger value) {
    return value.isOdd();
  }

  public static boolean isPrime(int value) {
    if (isEven(value) && value != 2)
      return false;
    return MyInteger.countDivisors(value) == 2;
  }

  public static boolean isPrime(MyInteger value) {
    return value.isPrime();
  }

  public boolean equals(int other) {
    return value == other;
  }

  public boolean equals(MyInteger other) {
    return value == other.value;
  }

  public static int countDivisors(int n) {
    if (n == 0) return 0;
    int count = 0;
    int inc = isEven(n) ? 1 : 2;

    for (int i = 1; i <= Math.sqrt(n); i += inc)
      if (n % i == 0) count++;
    return count;
  }

  public static int parseInt(char[] digits) {
    return MyInteger.parseInt(digits, false);
  }

  public static int parseInt(String integerString) {
    return MyInteger.parseInt(integerString.toCharArray());
  }

  public static int parseInt(String integerString, boolean skipNonDigits) {
    return MyInteger.parseInt(integerString.toCharArray(), skipNonDigits);
  }

  public static int parseInt(char[] digits, boolean skipNonDigits) {
    int value = 0, power = 0;

    for (char digit : digits) {
      if (!Character.isDigit(digit))
        if (skipNonDigits) continue;
        else
          throw new RuntimeException(
            String.format("Non-digit character: '%c' occured in '%s'", digit, String.valueOf(digits)));
      value = value * 10 + (digit - 48);
    }
    return value;
  }

  public static boolean isPrime(BigInteger number) {
    if (number.compareTo(BigInteger.ONE) <= 0 ||
      number.remainder(BigInteger.TWO).equals(BigInteger.ZERO))
      return false;
    if (number.equals(BigInteger.TWO))
      return true;
    for (BigInteger i = new BigInteger(""+3); i.compareTo(number.sqrt()) <= 0; i = i.add(BigInteger.TWO))
      if (number.remainder(i).equals(BigInteger.ZERO))
        return false;
    return true;
  }
}
