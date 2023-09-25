package chapter10.exercise13;


import util.MiniMath;

public class Rectangle2D {
  private double x, y;
  private double width, height;

  public Rectangle2D() {
    x = y = 0;
    width = height = 1;
  }

  public Rectangle2D(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public boolean contains(double x, double y) {
    return MiniMath.inRange(x, this.x, this.x + width) &&
      MiniMath.inRange(y, this.y, this.y + height);
  }

  public boolean overlaps(Rectangle2D other) {
    return MiniMath.rangeOverlap(x, x + width, other.x, other.x + other.width) &&
      MiniMath.rangeOverlap(y, y + height, other.y, other.y + other.height);
  }

  public double getArea() {
    return width * height;
  }

  public double getPerimeter() {
    return 2 * (width * height);
  }

  public double getY() {
    return y;
  }

  public double getX() {
    return x;
  }

  public static void main(String[] args) {
    Rectangle2D r1 = new Rectangle2D(2, 2, 5.5, 4.9);
    System.out.println(r1.getArea());
    System.out.println(r1.getPerimeter());
    System.out.println(r1.contains(3, 3));
    System.out.println(r1.contains(2, 2));


  }

}
