package chapter13.exercise05;

import chapter13.helper.InvalidTriangleException;

public class Triangle extends GeometricObject {
  private double side1, side2, side3;
  private boolean filled;
  private String color;

  public Triangle() {
    side1 = side2 = side3 = 1.0;
    filled = false;
  }

  public Triangle(double side1, double side2, double side3) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    this.filled = false;
    this.color = null;
  }

  public Triangle(double side1, double side2, double side3, String color) {
    this(side1, side2, side3);
    if (!isValid(side1, side2, side3))
      throw new InvalidTriangleException("Triangle is not valid for the sides: " +
          side1 + ", " + side2 + ", " + side3);
    this.filled = !color.equals("");
    this.color = color;
  }

  private boolean isValid(double side1, double side2, double side3) {
    return side1 < side2 + side3 && side2 < side1 + side3 &&
        side3 < side1 + side2;
  }

  @Override
  public double getArea() {
    double p = getPerimeter() / 2.0;
    return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
  }

  @Override
  public double getPerimeter() {
    return side1 + side2 + side3;
  }

  @Override
  public int compareTo(GeometricObject other) {
    return (int) Math.round(this.getArea() - other.getArea());
  }

  @Override
  public String toString() {
    return "Triangle[side1=" + side1 + ", side2=" + side2 +
        ", side3=" + side3 + ", filled=" + (filled ? "true, color=" + color + "]" : "false]");
  }
}
