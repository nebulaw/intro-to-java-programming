package chapter13.exercise03;

import java.util.ArrayList;
import java.util.Collections;

/**
 * (Sort ArrayList) Write the following method that sorts an ArrayList of numbers.
 * public static void sort(ArrayList<Number> list)
 * */

public class Exercise03 {

  public static void sort(ArrayList<Number> list) {
    for (int i = 0; i < list.size(); i++)
      for (int j = list.size() - 1; j > i; j--)
        if (list.get(j).floatValue() < list.get(i).floatValue())
          Collections.swap(list, i, j);
  }

  public static void main(String[] args) {
    ArrayList<Number> list = new ArrayList<>(5);

    for (int i = 0; i < 5; i++)
      list.add((float)Math.random() * 100);
    sort(list);

    System.out.println(list.stream()
        .map(Object::toString)
        .reduce((toks, tok) -> toks + ", " + tok).get());
  }
}
