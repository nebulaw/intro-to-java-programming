package chapter25.exercise05;

import chapter25.exercise01_02.BST;

public class Exercise25_05 {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<>();
    for (int i = 0; i < 10; i++)
      bst.insert((int)(Math.random() * 50));
    bst.postorder();
    System.out.println();
    bst.postorderNR();
  }
}
