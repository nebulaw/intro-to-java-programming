package chapter11.exercise13;

import java.util.ArrayList;

public class Main {
  public static ArrayList<Integer> removeDuplicate(ArrayList<Integer> list) {
    ArrayList<Integer> visited = new ArrayList<>();
    for (Integer number : list)
      if (!visited.contains(number))
        visited.add(number);
    return visited;
  }
}
