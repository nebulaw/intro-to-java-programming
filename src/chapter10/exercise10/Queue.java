package chapter10.exercise10;

public class Queue {
  private int[] queue;
  private int qp; // queue pointer
  private final static int DEFAULT_SIZE = 8;

  public Queue() {
    this(DEFAULT_SIZE);
  }

  public Queue(int size) {
    this.queue = new int[size];
  }

  public void enqueue(int e) {
    if (qp >= queue.length) {
      int[] temp = new int[queue.length * 2];
      System.arraycopy(queue, 0, temp, 0, queue.length);
      queue = temp;
    }
    queue[qp++] = e;
  }

  public int dequeue() {
    if (this.empty())
      throw new RuntimeException("Queue is empty");
    int val = queue[0];
    // remove val
    for (int i = 0; i < qp - 1; i++)
      queue[i] = queue[i + 1];
    qp--;
    return val;
  }

  public boolean empty() {
    return qp == 0;
  }

  public int getSize() {
    return qp;
  }

  public static void main(String[] args) {
    Queue q = new Queue(2);

    q.enqueue(2);
    q.enqueue(4);
    q.enqueue(6);
    q.enqueue(90);

    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue()); // throws exception
  }

}
