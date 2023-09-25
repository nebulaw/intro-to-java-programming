package chapter11.exercise01;

import java.util.Scanner;

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
    if (!isValid(side1, side2, side3))
      throw new RuntimeException("Triangle is not valid for the sides: " +
      side1 + ", " + side2 + ", " + side3);
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    this.filled = color.equals("") ? false : true;
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
  public String toString() {
    return "Triangle[side1=" + side1 + ", side2=" + side2 +
    ", side3=" + side3 + ", filled=" + (filled ? "true, color=" + color + "]" : "false]");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter three sides of triangles: ");
    double side1 = scanner.nextDouble();
    double side2 = scanner.nextDouble();
    double side3 = scanner.nextDouble();
    System.out.print("Want to fill? ");
    boolean filled = scanner.nextBoolean();
    String color = "";
    if (filled) {
      System.out.print("Enter color: ");
      color = scanner.next();
    }

    // create triangle
    Triangle triangle = new Triangle(side1, side2, side3, color);

    System.out.println("Area of your triangle is " + triangle.getArea());
    System.out.println("Perimeter is " + triangle.getPerimeter());
    System.out.println("Overall info: " + triangle);


  }
}
