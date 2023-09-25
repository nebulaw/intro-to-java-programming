package chapter13.exercise08;

/**
 * (Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to perform
 * a deep copy of the list field.
 * */

public class Exercise08 {
  public static void main(String[] args) {
    MyStack s1 = new MyStack();
    s1.push(1);
    s1.push(2);
    s1.push(3);

    MyStack s2 = (MyStack) s1.clone();
    System.out.println("s1 : " + s1);
    System.out.println("s2 : " + s2);
  }
}
