package chapter23.exercise13;

import chapter12.exercise03.Array;

import java.util.ArrayList;
import java.util.Random;

import static chapter20.exercise21.Exercise20_21.selectionSort;
import static chapter23.exercise01.Exercise23_01.bubbleSort;
import static chapter23.exercise02.Exercise23_02.mergeSort;
import static chapter23.exercise03.Exercise23_03.quickSort;
import static chapter23.exercise05.Exercise23_05.heapSort;

public class Exercise23_13 {
  private static Random random = new Random();

  public static void main(String[] args) {
    int[] amounts = new int[] { 50_000, 100_000, 150_000, 200_000, 250_000, 300_000 };

    printHeader();

    Integer[] numbers;
    long startTime, endTime;
    for (int amount : amounts) {
      // print array size
      System.out.printf("%-10d|", amount);

      // generate n size array
      numbers = generateList(amount);
      // selection sort
      startTime = System.currentTimeMillis();
      selectionSort(numbers, Integer::compare);
      endTime = System.currentTimeMillis();
      System.out.printf("%8dms|", endTime - startTime);


      numbers = generateList(amount);
      // bubble sort
      startTime = System.currentTimeMillis();
      bubbleSort(numbers);
      endTime = System.currentTimeMillis();
      System.out.printf("%8dms|", endTime - startTime);


      numbers = generateList(amount);
      // selection sort
      startTime = System.currentTimeMillis();
      mergeSort(numbers);
      endTime = System.currentTimeMillis();
      System.out.printf("%8dms|", endTime - startTime);


      numbers = generateList(amount);
      // quick sort
      startTime = System.currentTimeMillis();
      quickSort(numbers);
      endTime = System.currentTimeMillis();
      System.out.printf("%8dms|", endTime - startTime);


      numbers = generateList(amount);
      // heap sort
      startTime = System.currentTimeMillis();
      quickSort(numbers);
      endTime = System.currentTimeMillis();
      System.out.printf("%8dms|", endTime - startTime);

      System.out.println();
    }
  }

  public static Integer[] generateList(int n) {
      Integer[] retVals = new Integer[n];
      for (int i = 0; i < n; i++)
        retVals[i] = (random.nextInt(1000));
      return retVals;
  }

  public static void printHeader() {
    // print header
    System.out.printf("%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|\n", "Array", "Selection", "Bubble",
        "Merge", "Quick", "Heap");
    System.out.printf("%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|\n", "size", "Sort", "Sort", "Sort",
        "Sort", "Sort");
    for (int i = 0; i < 68; i++)
      System.out.print("-");
    System.out.println();
  }
}
