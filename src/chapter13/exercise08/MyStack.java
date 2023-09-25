package chapter13.exercise08;

import java.util.Arrays;
import java.util.Objects;

public class MyStack implements Cloneable {
  private int[] stack;
  private int sp;
  private static int INITIAL_SIZE = 32;

  public MyStack() {
    this(INITIAL_SIZE);
  }

  public MyStack(int size) {
    this.stack = new int[size];
    this.sp = 0;
  }

  public void push(int value) {
    if (sp >= stack.length) {
      int[] temp = new int[stack.length * 2];
      System.arraycopy(stack, 0, temp, 0, stack.length);
      stack = temp;
    }
    stack[sp++] = value;
  }

  public int pop() {
    if (sp < 1 )
      throw new RuntimeException("Cannot pop element from stack. Stack is empty.");
    return stack[--sp];
  }

  public int peek() {
    if (sp < 1)
      throw new RuntimeException("Cannot peek element from stack. Stack is empty.");
    return stack[sp - 1];
  }

  public boolean empty() {
    return sp == 0;
  }

  public int getSize() {
    return sp;
  }

  public MyStack copy() {
    MyStack ret = new MyStack();
    ret.sp = sp;
    ret.stack = this.toArray();
    return ret;
  }

  public boolean contains(int n) {
    for (int i = 0; i < getSize(); i++)
      if (stack[i] == n)
        return true;
    return false;
  }

  public int[] toArray() {
    int[] ret = new int[sp];
    System.arraycopy(stack, 0, ret, 0, sp);
    return ret;
  }

  public int[] toArrayReverse() {
    int[] ret = new int[sp];
    MyStack copyStack = this.copy();
    for (int i = 0; i < sp; i++)
      ret[i] = copyStack.pop();
    System.gc();
    return ret;
  }

  public static void setInitialSize(int size) {
    MyStack.INITIAL_SIZE = size;
  }

  public Object clone() {
    MyStack ret = new MyStack(sp);
    ret.sp = sp;
    ret.stack = new int[this.stack.length];
    System.arraycopy(this.stack, 0, ret.stack, 0, sp);
    return ret;
  }

  @Override
  public String toString() {
    String els = Arrays.stream(Arrays.copyOfRange(stack, 0, sp))
        .mapToObj(Objects::toString)
        .reduce("", (rest, curr) -> rest + " " + curr);
    return "Stack[size=" + sp + "," + els + " ]";
  }
}
