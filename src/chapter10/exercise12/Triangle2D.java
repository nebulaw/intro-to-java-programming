package chapter10.exercise12;

import chapter10.exercise04.MyPoint;
import util.MiniMath;

public class Triangle2D {
  private MyPoint p1, p2, p3;

  public Triangle2D() {
    p1 = new MyPoint();
    p2 = new MyPoint(1, 1);
    p3 = new MyPoint(2, 5);
  }

  public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  public boolean containsPoint(MyPoint point) {
    return this.getArea() == new Triangle2D(p1, p2, point).getArea() +
      new Triangle2D(p1, point, p3).getArea() + new Triangle2D(point, p2, p3).getArea();
  }

  public boolean containsTriangle(Triangle2D other) {
    return containsPoint(other.p1) && containsPoint(other.p2)
      && containsPoint(other.p3);
  }

  public boolean overlapsTriangle(Triangle2D other) {
    if (this.containsTriangle(other)) return false;
    // check if sides are overlapping
    return MiniMath.linesOverlap(p1, p2, other.p1, other.p2) ||
      MiniMath.linesOverlap(p1, p2, other.p2, other.p3) ||
      MiniMath.linesOverlap(p1, p2, other.p1, other.p3) ||
      MiniMath.linesOverlap(p2, p3, other.p1, other.p2) ||
      MiniMath.linesOverlap(p2, p3, other.p2, other.p3) ||
      MiniMath.linesOverlap(p2, p3, other.p1, other.p3) ||
      MiniMath.linesOverlap(p1, p3, other.p1, other.p2) ||
      MiniMath.linesOverlap(p1, p3, other.p2, other.p3) ||
      MiniMath.linesOverlap(p1, p3, other.p1, other.p3);
  }

  public double getArea() {
    double s = getPerimeter() / 2;
    return Math.sqrt(s * (s - p1.distance(p2)) * (s - p2.distance(p3)) *
      (s - p1.distance(p3)));
  }

  public double getPerimeter() {
    // two ways
    return p1.distance(p2) + p2.distance(p3) + p1.distance(p3);
  }

  public static void main(String[] args) {
    Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));
    System.out.println(t1.containsPoint(new MyPoint(3, 3)));
    System.out.println(t1.containsTriangle(new Triangle2D(
      new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));
    System.out.println(t1.overlapsTriangle(new Triangle2D(
      new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5))));
  }

}
