package chapter13.exercise07;

import chapter13.exercise05.GeometricObject;
import chapter13.helper.Colorable;

public class Square extends GeometricObject implements Colorable {
  private double s;

  public Square(double s) {
    this.s = s;
  }

  @Override
  public String howToColor() {
    return "Color all four sides.";
  }

  @Override
  public double getArea() {
    return s * s;
  }

  @Override
  public double getPerimeter() {
    return 4 * s;
  }

  @Override
  public int compareTo(GeometricObject geometricObject) {
    return (int)Math.round(this.getArea() - geometricObject.getArea());
  }
}
