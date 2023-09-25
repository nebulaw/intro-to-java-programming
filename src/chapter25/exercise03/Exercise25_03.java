package chapter25.exercise03;

import chapter25.exercise14.BST;

public class Exercise25_03 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>(Integer::compare);
        for (int i = 0; i < 10; i++)
            bst.insert((int)(Math.random() * 50));
        bst.inorder();
        System.out.println();
        bst.inorderNR();
    }
}
