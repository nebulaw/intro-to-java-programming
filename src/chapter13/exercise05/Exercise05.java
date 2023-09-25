package chapter13.exercise05;

/**
 * Modify the GeometricObject class
 * to implement the Comparable interface, and define a static max method in the
 * GeometricObject class for finding the larger of two GeometricObject objects.
 * Draw the UML diagram and implement the new GeometricObject class. Write
 * a test program that uses the max method to find the larger of two circles and the
 * larger of two rectangles.
 * */

public class Exercise05 {
  public static void main(String[] args) {
    Triangle t1 = new Triangle(3, 4, 5);
    Triangle t2 = new Triangle(4, 4, 5);

    System.out.println("Bigger triangle is " + GeometricObject.max(t1, t2));
  }
}
