package chapter13.exercise17;

public class Complex implements Cloneable {
  public static final Complex ZERO = new Complex();
  private double a, b;

  public Complex() {
    this(0, 0);
  }

  public Complex(double a) {
    this(a, 0);
  }

  public Complex(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public Complex add(Complex rhs) {
    double a = (this.a + rhs.getRealPart());
    double b = (this.b + rhs.getImaginaryPart());
    return new Complex(a, b);
  }

  public Complex subtract(Complex rhs) {
    double a = (this.a - rhs.getRealPart());
    double b = (this.b - rhs.getImaginaryPart());
    return new Complex(a, b);
  }

  public Complex multiply(Complex rhs) {
    double a = (this.a * rhs.getRealPart() - this.b * rhs.getImaginaryPart());
    double b = (this.b + rhs.getRealPart() - this.a * rhs.getImaginaryPart());
    return new Complex(a, b);
  }

  public Complex divide(Complex rhs) {
    double a = (this.a * rhs.getRealPart() + this.b * rhs.getImaginaryPart()) *
        (rhs.a * rhs.a + rhs.b * rhs.b);
    double b = (this.b * rhs.a - this.a * rhs.b) / (rhs.a * rhs.a + rhs.b * rhs.b);
    return new Complex(a, b);
  }

  public double getAbsoluteValue() {
    return Math.sqrt(a * a + b * b);
  }

  public double getRealPart() {
    return a;
  }

  public double getImaginaryPart() {
    return b;
  }

  @Override
  public Object clone() {
    return new Complex(a, b);
  }

  public String toString() {
    return String.format("(%.4f + %.4fi)", a, b);
  }
}
