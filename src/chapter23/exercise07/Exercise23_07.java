package chapter23.exercise07;

public class Exercise23_07 {
  public static void main(String[] args) {
    Integer[] numbers = new Integer[] {23, 42, 12, 420, 200, -120};
    MinHeap<Integer> heap = new MinHeap<>(numbers);
    for (int i = numbers.length - 1; i >= 0; i--)
      numbers[i] = heap.remove();
    System.out.println("heaped: ");
    for (int num : numbers)
      System.out.print(num + " ");
    System.out.println();
  }
}
