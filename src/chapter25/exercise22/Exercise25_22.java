package chapter25.exercise22;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exercise25_22 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter the number of weights: ");
    int n = in.nextInt();
    PriorityQueue<Integer> weights = new PriorityQueue<>(n, (x, y) -> -Integer.compare(x, y));
    System.out.print("Enter the weights: ");
    for (int i = 0; i < n; i++)
      weights.add(in.nextInt());

    int count = 1;
    while (!weights.isEmpty()) {
      ArrayList<Integer> resWeights = new ArrayList<>();
      int sum = weights.poll();
      resWeights.add(sum);
      while (!weights.isEmpty() && sum + weights.peek() < 10) {
        int weight = weights.poll();
        sum += weight;
        resWeights.add(weight);
      }
      System.out.println("Container " + count + " contains objects with weights " + resWeights);
      count++;
    }
  }
}
