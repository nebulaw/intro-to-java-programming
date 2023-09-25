package chapter10.exercise05;


import chapter10.util.Stack;

/**
 * Write a program that prompts the user to enter
 * a positive integer and displays all its smallest factors in decreasing order. For
 * example, if the integer is 120, the smallest factors are displayed as 5, 3, 2, 2,
 * 2.
 * */
public class Main {

  public static int[] getPrimeFactors(int number) {
    if (number < 1) return new int[] {};
    Stack factors = new Stack();
    int smallestFactor = 2;

    while (number > 1) {
      if (number % smallestFactor == 0) {
        factors.push(smallestFactor);
        number /= smallestFactor;
      } else
        smallestFactor++;
    }

    return factors.toArray();
  }

  public static void main(String[] args) {
    for (int factor : getPrimeFactors(120))
      System.out.print(factor + " ");
    System.out.println();
  }
}
