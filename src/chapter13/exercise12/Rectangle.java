package chapter13.exercise12;

import chapter13.exercise05.GeometricObject;

public class Rectangle extends GeometricObject {
  private double w, h;

  public Rectangle(double w, double h) {
    this.w = w;
    this.h = h;
  }

  @Override
  public double getArea() {
    return w * h;
  }

  @Override
  public double getPerimeter() {
    return 2 * (w + h);
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Rectangle))
      return false;
    return this.getArea() == ((Rectangle) other).getArea();
  }

  @Override
  public int compareTo(GeometricObject geometricObject) {
    return (int)Math.round(this.getArea() - geometricObject.getArea());
  }
}
