package chapter25.exercise15;

import java.util.Scanner;

public class Exercise25_15 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    Integer firstInteger;
    BST<Integer> tree = new BST<>();
    System.out.print("Enter 10 integers: ");
    firstInteger = in.nextInt();
    tree.insert(firstInteger);
    for (int i = 0; i < 9; i++)
      tree.insert(in.nextInt());
    tree.delete(firstInteger);
  }
}
