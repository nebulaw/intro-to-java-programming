package chapter10.exercise04;

public class MyPoint {
  private double x, y;

  public MyPoint() {
    x = y = 0;
  }

  public MyPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double magnitude() {
    return Math.sqrt(x * x + y * y);
  }

  public double distance(MyPoint other) {
    return distance(other.x, other.y);
  }

  public double distance(double x, double y) {
    double dx = this.x - x;
    double dy = this.y - y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof MyPoint))
      return false;
    return this.x == ((MyPoint)other).x && this.y == ((MyPoint)other).y;
  }

  public static void sayHi() {
    System.out.println("I said hi");
  }

}
