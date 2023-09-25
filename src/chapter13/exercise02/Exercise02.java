package chapter13.exercise02;

import java.util.ArrayList;
import java.util.Collections;

/**
 * (Shuffle ArrayList) Write the following method that shuffles an ArrayList of
 * numbers:
 *  public static void shuffle(ArrayList<Number> list)
 * */

public class Exercise02 {

  public static void shuffle(ArrayList<Number> list) {
    for (int i = 0; i < list.size(); i++) {
      int randIndex = (int)(Math.round(Math.random() * (list.size() - i - 1)));
      Collections.swap(list, i, randIndex);
    }
  }

  public static void main(String[] args) {
    ArrayList<Number> list = new ArrayList<>(5);

    for (int i = 0; i < 5; i++)
      list.add(Math.random() * 100);
    shuffle(list);

    System.out.println(list.stream()
            .map(Object::toString)
            .reduce((toks, tok) -> toks + ", " + tok).get());

  }
}
