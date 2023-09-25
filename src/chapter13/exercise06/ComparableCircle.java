package chapter13.exercise06;

import chapter13.helper.Circle;

public class ComparableCircle extends Circle {

  public ComparableCircle(double radius) {
    super(radius);
  }

  public int compareTo(Circle o) {
    return (int)Math.round(this.getArea() - o.getArea());
  }

}
