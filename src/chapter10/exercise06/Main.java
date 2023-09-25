package chapter10.exercise06;


import chapter10.util.Stack;

/**
 * (Displaying the prime numbers) Write a program that displays all the prime
 * numbers less than 120 in decreasing order. Use the StackOfIntegers class
 * to store the prime numbers (e.g., 2, 3, 5, ...) and retrieve and display them in
 * reverse order.
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

    return factors.toArrayReverse();
  }

  public static void main(String[] args) {
    for (int factor : getPrimeFactors(120))
      System.out.print(factor + " ");
    System.out.println();
  }
}
