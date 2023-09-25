package chapter13.helper;

import chapter13.exercise05.GeometricObject;

public class Circle extends GeometricObject {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  public double getPerimeter() {
    return Math.PI * radius * 2;
  }

  public boolean equals(Object other) {
    if (!(other instanceof Circle))
      return false;
    return radius == ((Circle) other).radius;
  }

  public String toString() {
    return "Circle[radius=" + radius + "]";
  }

  @Override
  public int compareTo(GeometricObject geometricObject) {
    return (int)Math.round(this.getArea() - geometricObject.getArea());
  }
}
