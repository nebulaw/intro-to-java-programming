package chapter13.exercise07;

/**
 * (The Colorable interface) Design an interface named Colorable with a void
 * method named howToColor(). Every class of a colorable object must implement
 * the Colorable interface. Design a class named Square that extends
 * GeometricObject and implements Colorable. Implement howToColor to
 * display the message Color all four sides.
 * */

public class Exercise07 {
  public static void main(String[] args) {
    Square square = new Square(12);

    System.out.println(square.howToColor());
  }
}
