package chapter25.exercise20;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise25_20 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    ArrayList<Integer> weights = new ArrayList<>();
    System.out.print("Enter the number of weights: ");
    int n = in.nextInt();
    for (int i = 0; i < n; i++)
      weights.add(in.nextInt());

    int count = 1;

    while (!weights.isEmpty()) {
      ArrayList<Integer> resWeights = new ArrayList<>();
      int num = weights.remove(0);
      resWeights.add(num);
      for (int i = 0; i < weights.size(); i++) {
        if (num + weights.get(i) <= 10) {
          resWeights.add(weights.remove(i));
          num += resWeights.get(resWeights.size() - 1);
        }
      }
      System.out.println("Container " + count + " contains objects with weights " + resWeights);
      count++;
    }

  }
}
