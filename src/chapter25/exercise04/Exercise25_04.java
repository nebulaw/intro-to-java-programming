package chapter25.exercise04;

import chapter25.exercise14.BST;

import java.util.Random;

public class Exercise25_04 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>(Integer::compare);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int rand = random.nextInt(50);
            System.out.print(rand + " ");
            bst.insert(rand);
        }
        System.out.println();

        bst.preorder();
        System.out.println();
        bst.preorderNR();
    }
}
