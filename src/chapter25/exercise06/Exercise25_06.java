package chapter25.exercise06;

import chapter25.exercise01_02.BST;

public class Exercise25_06 {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<>();
    for (int i = 0; i < 10; i++)
      bst.insert((int)(Math.random() * 50));

    System.out.println(bst.getNumberOfLeaves());
  }
}
