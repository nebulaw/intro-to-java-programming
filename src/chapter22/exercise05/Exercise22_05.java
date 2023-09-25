package chapter22.exercise05;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Not solved
 * */

public class Exercise22_05 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    ArrayList<Integer> numbers = new ArrayList<>();
    System.out.print("Enter numbers: ");
    int number;
    while ((number = in.nextInt()) != 0)
      numbers.add(number);

    int[] result = numberSubsequence(numbers);

    System.out.println("The longest same number sequence starts at index " + result[0] +
        " with " + result[1] + " values of " + result[2]);
  }

  public static int[] numberSubsequence(ArrayList<Integer> numbers) {
    if (numbers.isEmpty()) return new int[] { -1, -1, -1 };
    int startingIndex = 0, lengthOfSequence = 0, number = numbers.get(0);

    int maxLength = 0, count = 1;
    for (int i = 0; i < numbers.size() - 1; i++) {
      if (numbers.get(i + 1) == 0) break;
      if (numbers.get(i + 1) == numbers.get(i)) {
        count++;
        maxLength = Math.max(maxLength, count);
        if (count == maxLength) {
          number = numbers.get(i);
        }
      } else {
        startingIndex = i + 1;
        count = 1;
      }
    }

    return new int[] { startingIndex, lengthOfSequence, number };
  }

}
