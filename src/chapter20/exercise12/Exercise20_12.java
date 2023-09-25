package chapter20.exercise12;

public class Exercise20_12 {
  public static void main(String[] args) {
    MyPriorityQueue<Integer> q1 = new MyPriorityQueue<>();
    q1.offer(1);
    q1.offer(90);
    q1.offer(120);
    q1.offer(585);

    MyPriorityQueue<Integer> q2 = q1.clone();
    q2.poll();
    System.out.print("Cloned: ");
    for (int n : q2)
      System.out.print(n + " ");
    System.out.println();

    System.out.print("Initial: ");
    for (int n : q1)
      System.out.print(n + " ");
    System.out.println();

  }
}
