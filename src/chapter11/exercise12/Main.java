package chapter11.exercise12;

import java.util.ArrayList;

public class Main {
  public static double sum(ArrayList<Double> list) {
    double sum = 0;
    for (double d : list) sum += d;
    return sum;
  }
}
