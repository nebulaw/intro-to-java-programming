package chapter13.exercise15;

import java.math.BigInteger;

public class RationalBI extends Number implements Comparable<RationalBI> {
  // Data fields for numerator and denominator
  private BigInteger numerator, denominator;
  /** Construct a rational with default properties */
  public RationalBI() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }
  /** Construct a rational with specified numerator and denominator */
  public RationalBI(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = gcd(numerator, denominator);
    int sign = denominator.compareTo(BigInteger.ZERO);
    this.numerator = numerator.multiply(BigInteger.valueOf(sign)).divide(gcd);
    this.denominator = denominator.abs().divide(gcd);
  }
  /** Find GCD of two numbers */
  private static BigInteger gcd(BigInteger n, BigInteger d) {
    BigInteger n1 = n.abs();
    BigInteger n2 = d.abs();
    BigInteger gcd = BigInteger.ONE;
    for (BigInteger k = BigInteger.ONE;
         k.compareTo(n1) < 0 && k.compareTo(n2) < 0;
         k = k.add(BigInteger.ONE)) {
      if (n1.mod(k).equals(BigInteger.ZERO) &&
          n2.mod(k).equals(BigInteger.ZERO))
        gcd = k;
    }
    return gcd;
  }
  /** Return numerator */
  public BigInteger getNumerator() {
    return numerator;
  }
  /** Return denominator */
  public BigInteger getDenominator() {
    return denominator;
  }
  /** Add a rational number to this rational */
  public RationalBI add(RationalBI secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator()).add(
        denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new RationalBI(n, d);
  }
  /** Subtract a rational number from this rational */
  public RationalBI subtract(RationalBI secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(
        denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new RationalBI(n, d);
  }
  /** Multiply a rational number by this rational */
  public RationalBI multiply(RationalBI secondRational) {
    BigInteger n = numerator.multiply(secondRational.getNumerator());
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new RationalBI(n, d);
  }
  /** Divide a rational number by this rational */
  public RationalBI divide(RationalBI secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator());
    BigInteger d = denominator.multiply(secondRational.getNumerator());
    return new RationalBI(n, d);
  }
  @Override
  public String toString() {
    if (denominator.equals(BigInteger.ONE))
      return numerator + "";
    else
      return numerator + "/" + denominator;
  }
  @Override // Override the equals method in the Object class
  public boolean equals(Object other) {
    return (this.subtract((RationalBI) (other))).getNumerator().equals(BigInteger.ZERO);
  }
  @Override
  public int intValue() {
    return (int)doubleValue();
  }
  @Override // Implement the abstract floatValue method in Number
  public float floatValue() {
    return (float)doubleValue();
  }
  @Override // Implement the doubleValue method in Number
  public double doubleValue() {
    return numerator.multiply(BigInteger.ONE).divide(denominator).doubleValue();
  }
  @Override // Implement the abstract longValue method in Number
  public long longValue() {
    return (long)doubleValue();
  }
  @Override // Implement the compareTo method in Comparable
  public int compareTo(RationalBI o) {
    return Integer.compare(this.subtract(o).getNumerator().compareTo(BigInteger.ZERO), 0);
  }
}