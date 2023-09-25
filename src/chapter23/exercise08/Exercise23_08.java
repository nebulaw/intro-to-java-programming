package chapter23.exercise08;

import util.Heap;

public class Exercise23_08 {
  public static <E extends Comparable<E>> void sort(E[] list) {
    Heap<E> heap = new Heap<>(list);
    for (int i = list.length - 1; i >= 0; i--)
      list[i] = heap.remove();
  }

  public static void main(String[] args) {
    Integer[] numbers = new Integer[] {23, 42, 12, 420, 200, -120};
    sort(numbers);
    for (int num : numbers)
      System.out.print(num + " ");
    System.out.println();
  }
}
