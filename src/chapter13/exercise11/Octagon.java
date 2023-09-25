package chapter13.exercise11;

import chapter13.exercise05.GeometricObject;

public class Octagon extends GeometricObject implements Comparable<GeometricObject>, Cloneable {
  private double side;

  public Octagon(double side) {
    this.side = side;
  }

  @Override
  public double getArea() {
    return (2 + 4 / Math.sqrt(2)) * side * side;
  }

  @Override
  public double getPerimeter() {
    return 8 * side;
  }

  @Override
  public Object clone() {
    return new Octagon(side);
  }

  @Override
  public int compareTo(GeometricObject geometricObject) {
    return Double.compare(this.getArea(), geometricObject.getArea());
  }
}
