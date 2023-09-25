package chapter13.exercise05;

public abstract class GeometricObject implements Comparable<GeometricObject> {

  public abstract double getArea();

  public abstract double getPerimeter();

  public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
    return o1.compareTo(o2) >= 0 ? o1 : o2;
  }

}
