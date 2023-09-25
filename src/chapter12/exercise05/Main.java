package chapter12.exercise05;

import java.util.Scanner;

public class Main {
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
    scanner.close();

    // create triangle
    Triangle triangle = new Triangle(side1, side2, side3, color);

    System.out.println("Area of your triangle is " + triangle.getArea());
    System.out.println("Perimeter is " + triangle.getPerimeter());
    System.out.println("Overall info: " + triangle);
  }
}
