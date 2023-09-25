package chapter13.exercise10;

public class Rectangle extends GeometricObject implements Comparable<Rectangle> {
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
  public int compareTo(Rectangle o) {
    return Double.compare(this.getArea(), o.getArea());
  }
}
