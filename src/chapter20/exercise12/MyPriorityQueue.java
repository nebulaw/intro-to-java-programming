package chapter20.exercise12;

import java.util.PriorityQueue;

public class MyPriorityQueue<T> extends PriorityQueue<T> implements Cloneable {
  @Override
  public MyPriorityQueue<T> clone() {
    MyPriorityQueue<T> clone = new MyPriorityQueue<>();
    clone.addAll(this);
    return clone;
  }
}
