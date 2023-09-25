package chapter13.exercise09;


public class Circle extends GeometricObject implements Comparable<Circle> {
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

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Circle))
      return false;
    return radius == ((Circle) other).radius;
  }

  @Override
  public String toString() {
    return "Circle[radius=" + radius + "]";
  }

  @Override
  public int compareTo(Circle o) {
    return Double.compare(this.radius, o.radius);
  }
}
