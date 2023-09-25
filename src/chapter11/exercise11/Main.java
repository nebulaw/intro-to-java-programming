package chapter11.exercise11;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void sort(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++)
      for (int j = list.size() - 1; j > i; j--)
        if (list.get(j) < list.get(j - 1))
          Collections.swap(list, j, j - 1);
  }

}
