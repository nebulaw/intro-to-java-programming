package chapter25.exercise14;

public class Exercise25_14 {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<>(Integer::compare);
    for (int i = 0; i < 10; i++)
      bst.insert((int)(Math.random() * 50));
    bst.postorder();
    System.out.println();
  }
}
