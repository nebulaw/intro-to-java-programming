package chapter20.exercise21;

import chapter13.helper.Circle;
import chapter13.exercise05.GeometricObject;
import chapter13.exercise12.Rectangle;

import java.util.Comparator;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {
        new Circle(5),
        new Rectangle(4, 5),
        new Circle(5.5),
        new Rectangle(2.4, 5),
        new Circle(0.5),
        new Rectangle(4, 65),
        new Circle(4.5),
        new Rectangle(4.4, 1),
        new Circle(6.5),
        new Rectangle(4, 5)
    };
    selectionSort(list, (o1, o2) -> (int) (o1.getArea() - o2.getArea()));

    for (GeometricObject o: list)
      System.out.printf("%.6f ", o.getArea());
    System.out.println();
  }

  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
    for (int i = 0; i < list.length - 1; i++) {
      E cMin = list[i];
      int cIdx = i;
      for (int j = i + 1; j < list.length; j++)
        if (comparator.compare(cMin, list[j]) > 0) {
          cMin = list[j];
          cIdx = j;
        }
      if (cIdx != i) {
        list[cIdx] = list[i];
        list[i] = cMin;
      }
    }
  }

}
