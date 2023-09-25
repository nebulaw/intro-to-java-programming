package chapter25.exercise23;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exercise25_23 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter the number of weights: ");
    int n = in.nextInt();
    PriorityQueue<Integer> weights = new PriorityQueue<>(n, (x, y) -> -Integer.compare(x, y));
    System.out.print("Enter the weights: ");
    for (int i = 0; i < n; i++)
      weights.add(in.nextInt());

    Integer minWeights = null;
    ArrayList<ArrayList<Integer>> bestCombination = new ArrayList<>();
    for (int j = 1; j < Math.pow(2, weights.size()); j++) {
      ArrayList<ArrayList<Integer>> currentWeights = new ArrayList<>();
      int w = weights.poll();
      int sum = 0, idx = 0;
      for (int i = 0; i < n; i++) {
        if (sum + w <= 10) {
          if (idx == currentWeights.size())
            currentWeights.add(new ArrayList<>());
          currentWeights.get(idx).add(w);
          sum += w;
        } else {
          sum = 0;
          --i; idx++;
        }
      }
      if (minWeights == null)
        minWeights = currentWeights.size();
      if (currentWeights.size() < minWeights) {
        minWeights = currentWeights.size();
        bestCombination = currentWeights;
      }
    }

    for (int i = 0; i < bestCombination.size(); i++) {
      System.out.print("Container " + (i+1) + " contains objects with weights: ");
      for (int j = 0; j < bestCombination.get(i).size(); j++)
        System.out.print(bestCombination.get(i).get(j) + " ");
      System.out.println();
    }

  }
}
