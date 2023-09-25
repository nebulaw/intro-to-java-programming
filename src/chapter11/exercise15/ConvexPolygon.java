package chapter11.exercise15;


import chapter10.exercise04.MyPoint;
import chapter10.exercise12.Triangle2D;

import java.util.ArrayList;
import java.util.Scanner;

public class ConvexPolygon {

  ArrayList<MyPoint> points;

  public ConvexPolygon(ArrayList<MyPoint> points) {
    if (points.size() < 2)
      throw new RuntimeException("Cannot create convex polygon from " + points.size() + " points");
    this.points = points;
  }

  public double getArea() {
    double totalArea = 0;
    for (int i = 1; i < points.size() - 1; i++)
      totalArea += new Triangle2D(points.get(0), points.get(i), points.get(i + 1)).getArea();
    return totalArea;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of the points: ");
    int number = sc.nextInt();

    ArrayList<MyPoint> points = new ArrayList<>(number);
    System.out.print("Enter the coordinates of the points: ");
    for (int i = 0; i < number; i++)
      points.add(new MyPoint(sc.nextDouble(), sc.nextDouble()));

    ConvexPolygon polygon = new ConvexPolygon(points);
    System.out.println("The total area is " + polygon.getArea());
  }
}
