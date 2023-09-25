package chapter13.exercise06;

/**
 * (The ComparableCircle class) Define a class named ComparableCircle
 * that extends Circle and implements Comparable. Draw the UML diagram and
 * implement the compareTo method to compare the circles on the basis of area.
 * Write a test class to find the larger of two instances of ComparableCircle objects.
 * */

public class Exercise06 {
  public static void main(String[] args) {
    ComparableCircle c1 = new ComparableCircle(5);
    ComparableCircle c2 = new ComparableCircle(5);

    if (c1.compareTo(c2) < 0)
      System.out.println("c2 is greater");
    else if (c1.compareTo(c2) == 0)
      System.out.println("both are equal");
    else
      System.out.println("c1 is greater");
  }
}
