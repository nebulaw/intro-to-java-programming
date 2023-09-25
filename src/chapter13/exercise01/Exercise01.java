package chapter13.exercise01;

import chapter13.exercise05.Triangle;

import java.util.Scanner;

/**
 * (Triangle class) Design a new Triangle class that extends the abstract
 * GeometricObject class. Draw the UML diagram for the classes Triangle
 * and GeometricObject and then implement the Triangle class. Write a test
 * program that prompts the user to enter three sides of the triangle, a color, and a
 * Boolean value to indicate whether the triangle is filled. The program should create
 * a Triangle object with these sides and set the color and filled properties using
 * the input. The program should display the area, perimeter, color, and true or false
 * to indicate whether it is filled or not.
 */

public class Exercise01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double side1, side2, side3;
    String color = "";

    System.out.print("Enter three sides of triangles: ");
    side1 = scanner.nextDouble();
    side2 = scanner.nextDouble();
    side3 = scanner.nextDouble();

    System.out.print("Want to fill? ");
    if (scanner.nextBoolean()) {
      System.out.print("Enter color: ");
      color = scanner.next();
    }

    // create triangle
    Triangle triangle = new Triangle(side1, side2, side3, color);

    System.out.println("Area of your triangle is " + triangle.getArea());
    System.out.println("Perimeter is " + triangle.getPerimeter());
    System.out.println("Triangle info: " + triangle);
  }
}
