package chapter25.exercise18;

import util.Heap;

import java.util.Scanner;

public class HuffmanCode {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter text: ");
    String text = in.next();

    int[] counts = getCharFrequency(text);
    System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "Character", "Frequency", "Code");
    Tree tree = getHuffmanTree(counts);
    String[] codes = getCode(tree.root);

    for (int i = 0; i < codes.length; i++)
      if (counts[i] != 0)
        System.out.printf("%-15d%-15s%-15d%-15s\n", i, (char)i + "", counts[i], codes[i]);

  }

  public static String[] getCode(Tree.Node root) {
    if (root == null) return null;
    String[] codes = new String[2 * 128];
    assignCode(root, codes);
    return codes;
  }

  private static void assignCode(Tree.Node root, String[] codes) {
    if (root.left != null) {
      root.left.code = root.code + "0";
      assignCode(root.left, codes);
      root.right.code = root.code + "1";
      assignCode(root.right, codes);
    }
    else {
      codes[(int)root.element] = root.code;
    }
  }

  public static Tree getHuffmanTree(int[] counts) {
    Heap<Tree> heap = new Heap<>(); // Defined in Listing 23.9
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0)
        heap.add(new Tree(counts[i], (char)i)); // A leaf node tree
    }
    while (heap.getSize() > 1) {
      Tree t1 = heap.remove(); // Remove the smallest-weight tree
      Tree t2 = heap.remove(); // Remove the next smallest
      heap.add(new Tree(t1, t2)); // Combine two trees
    }
    return heap.remove(); // The final tree
  }

  public static int[] getCharFrequency(String text) {
    int[] counts = new int[256]; // 256 ASCII characters
    for (int i = 0; i < text.length(); i++)
      counts[(int)text.charAt(i)]++; // Count the characters in text
    return counts;
  }

  public static class Tree implements Comparable<Tree> {
    Node root; // The root of the tree
    public Tree(Tree t1, Tree t2) {
      root = new Node();
      root.left = t1.root;
      root.right = t2.root;
      root.weight = t1.root.weight + t2.root.weight;
    }
    /** Create a tree containing a leaf node */
    public Tree(int weight, char element) {
      root = new Node(weight, element);
    }
    @Override /** Compare trees based on their weights */
    public int compareTo(Tree t) {
      if (root.weight < t.root.weight) // Purposely reverse the order
        return 1;
      else if (root.weight == t.root.weight)
        return 0;
      else
        return -1;
    }
    public class Node {
      char element; // Stores the character for a leaf node
      int weight; // weight of the subtree rooted at this node
      Node left; // Reference to the left subtree
      Node right; // Reference to the right subtree
      String code = ""; // The code of this node from the root
      /** Create an empty node */
      public Node() {
      }
      /** Create a node with the specified weight and character */
      public Node(int weight, char element) {
        this.weight = weight;
        this.element = element;
      }
    }
  }
}
