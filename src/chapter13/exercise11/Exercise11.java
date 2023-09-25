package chapter13.exercise11;

/**
 * (The Octagon class) Write a class named Octagon that extends
 * GeometricObject and implements the Comparable and Cloneable inter-
 * faces. Assume that all eight sides of the octagon are of equal length. The area can
 * be computed using the following formula:
 * area = (2 + 4/ sqrt(22))* side * side
 * Write a test program that creates an Octagon
 * object with side value 5 and displays its area and perimeter. Create a new object
 * using the clone method and compare the two objects using the compareTo
 * method.
 * */

public class Exercise11 {
  public static void main(String[] args) {
    Octagon o1 = new Octagon(5);
    System.out.println("Area is " + o1.getArea());
    System.out.println("Perimeter is " + o1.getPerimeter());

    Octagon o2 = (Octagon) o1.clone();

    if (o1.compareTo(o2) < 0)
      System.out.println("o2 is greater.");
    else if (o1.compareTo(o2) == 0)
      System.out.println("both are equal.");
    else
      System.out.println("o1 is greater");
  }
}
