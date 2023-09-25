package chapter10.exercise11;

public class Circle2D {
  private double x, y, radius;

  public Circle2D() {
    x = y = 0;
    radius = 1;
  }

  public Circle2D(double x, double y) {
    this.x = x;
    this.y = y;
    this.radius = 0;
  }

  public Circle2D(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  public double getPerimeter() {
    return Math.PI * radius * 2;
  }

  public boolean contains(double x, double y) {
    return Math.pow((x - this.x), 2) +
      Math.pow((y - this.y), 2) < radius * radius;
  }

  public boolean contains(Circle2D other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) +
      Math.pow(this.y - other.y, 2)) + other.radius <= this.radius;
  }

  public boolean overlaps(Circle2D other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) +
      Math.pow(this.y - other.y, 2)) <= this.radius + other.radius;
  }

  @Override
  public String toString() {
    return "Circle[x=" + x + ", y=" + y + ", r=" + radius + "]";
  }

  public static void main(String[] args) {
    Circle2D c1 = new Circle2D(2, 2, 5.5);

    System.out.println(c1.contains(3, 3));
    System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
    System.out.println(c1.overlaps(new Circle2D(3, 5, 2.5)));
  }

}
