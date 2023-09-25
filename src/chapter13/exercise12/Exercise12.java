package chapter13.exercise12;

import chapter13.helper.Circle;
import chapter13.exercise05.GeometricObject;

/**
 * (Sum the areas of geometric objects) Write a method that sums the areas of all the
 * geometric objects in an array. The method signature is:
 * public static double sumArea(GeometricObject[] a)
 * Write a test program that creates an array of four objects (two circles and two
 * rectangles) and computes their total area using the sumArea method.
 * */

public class Exercise12 {

  public static double sumArea(GeometricObject[] a) {
    double sum = 0;
    for (GeometricObject o : a)
      sum += o.getArea();
    return sum;
  }

  public static void main(String[] args) {
    GeometricObject[] a = new GeometricObject[4];
    a[0] = new Circle(2);
    a[1] = new Circle(4);
    a[2] = new Rectangle(4, 12);
    a[3] = new Rectangle(12, 5);

    System.out.println("Sum of the objects: " + sumArea(a));
  }
}
