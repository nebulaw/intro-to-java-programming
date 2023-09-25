package chapter11.exercise10;

import java.util.ArrayList;

public class StackList {
  private ArrayList<Integer> stack;

  public StackList() {
    stack = new ArrayList<>();
  }

  public StackList(int size) {
    stack = new ArrayList<>(size);
  }

  public void push(Integer n) {
    stack.add(n);
  }

  public Integer pop() {
    if (stack.isEmpty())
      return null;
    return stack.remove(stack.size() - 1);
  }

  public Object peek() {
    return stack.get(stack.size() - 1);
  }

  public void sort() {
    chapter11.exercise11.Main.sort(stack);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Integer number : stack)
      sb.append(number).append(" ");
    return sb.toString();
  }
}
