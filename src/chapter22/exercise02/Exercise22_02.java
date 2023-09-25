package chapter22.exercise02;

import java.util.Scanner;

/**
 * Maximum increasingly ordered subsequence
 * */

public class Exercise22_02 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter the word: ");
    String word = in.next();

    System.out.println(maxIncSubsequence(word));
  }

  public static String maxIncSubsequence(String word) {
    if (word.isEmpty())
      return "";

    String maxSubsequence = "";
    char nextChar = word.charAt(0);
    for (int j = 1; j < word.length(); j++)
      if (nextChar < word.charAt(j)) {
        maxSubsequence += nextChar;
        nextChar = word.charAt(j);
      }
    maxSubsequence += nextChar;
    return maxSubsequence;
  }
}
