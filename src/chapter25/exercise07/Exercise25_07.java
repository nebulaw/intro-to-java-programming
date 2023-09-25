package chapter25.exercise07;

import chapter25.exercise14.BST;

public class Exercise25_07 {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<>(Integer::compare);
    for (int i = 0; i < 10; i++) {
      int rand = (int)(Math.random() * 50);
      System.out.print(rand + " ");
      bst.insert(rand);
    }
    System.out.println();

    System.out.println(bst.getNumberOfLeaves());
    System.out.println(bst.getNumberOfNonLeaves());
  }
}
