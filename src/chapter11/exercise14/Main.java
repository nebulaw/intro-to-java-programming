package chapter11.exercise14;

import java.util.ArrayList;

public class Main {
  public static ArrayList<Integer> union(ArrayList<Integer> l1, ArrayList<Integer> l2) {
    ArrayList<Integer> union = new ArrayList<>(l1);
    union.addAll(l2);
    return union;
  }
}
