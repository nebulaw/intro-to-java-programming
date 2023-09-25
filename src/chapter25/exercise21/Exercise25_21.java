package chapter25.exercise21;

import util.MiniMath;

import java.util.*;

public class Exercise25_21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of weights: ");
        int n = in.nextInt();
        PriorityQueue<Integer> weights = new PriorityQueue<>(n);
        System.out.print("Enter the weights: ");
        for (int i = 0; i < n; i++)
            weights.add(in.nextInt());

        int count = 1;
        while (!weights.isEmpty()) {
            ArrayList<Integer> resWeights = new ArrayList<>();
            int num = weights.poll();
            resWeights.add(num);
            while (!weights.isEmpty() && num + weights.peek() <= 10) {
                int weight = weights.poll();
                num += weight;
                resWeights.add(weight);
            }
            System.out.println("Container " + count + " contains objects with weights" + resWeights);
            count++;
        }


    }
}
