package chapter11.exercise04;

import java.util.ArrayList;

public class Main {
  public static Integer max(ArrayList<Integer> list) {
    if (list.size() == 0)
      return null;
    Integer max = list.get(0);
    for (Integer i : list)
      if (i > max) max = i;
    return max;
  }
}
