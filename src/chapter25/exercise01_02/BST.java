package chapter25.exercise01_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (E object : objects) insert(object);
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                return true; // Element is found
        }
        return false;
    }

    public void breadthFirstTraversal() {
        if (this.root == null)
            return;
        LinkedList<TreeNode<E>> linkedList = new LinkedList<>();
        linkedList.add(this.root);
        while (!linkedList.isEmpty()) {
            TreeNode<E> current = linkedList.element();
            if (current.left != null)
                linkedList.add(current.left);
            if (current.right != null)
                linkedList.add(current.right);
            System.out.print(linkedList.poll() + ", ");
        }
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode<E> current) {
        if (current == null)
            return 0;
        int d1 = height(current.left);
        int d2 = height(current.right);
        return Math.max(d1, d2) + 1;
    }

    public boolean isFullBST() {
        if (this.root == null)
            return false;
        return size == Math.pow(2, height()) - 1;
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }


    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorderNR() {
        inorderNR(root);
    }

    protected void inorderNR(TreeNode<E> node) {
        if (node == null) return;
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            // store left nodes first
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            // middle node
            currentNode = stack.pop();
            System.out.print(currentNode.element + " ");
            currentNode = currentNode.right;
        }
    }

    public void preorderNR() {
        if (root == null)
            return;

        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<E> node = stack.pop();
            System.out.print(node.element + " ");

            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
    }

    public void postorderNR() {
        if (root == null)
            return;
        Stack<TreeNode<E>> stack = new Stack<>();
        Stack<TreeNode<E>> outputStack = new Stack<>(); // For storing the postorder traversal result
        stack.push(root); // Start with the root node

        while (!stack.isEmpty()) {
            TreeNode<E> current = stack.pop();
            outputStack.push(current); // Push the current node to the output stack
            // Push the left child first, then the right child, so right is processed before left (postorder)
            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }

        // Now, the elements are in the outputStack in the correct postorder
        while (!outputStack.isEmpty()) {
            TreeNode<E> current = outputStack.pop();
            System.out.print(current.element + " ");
        }
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int getNumberOfLeaves() {
        if (root == null)
            return 0;
        int count = 0;
        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<E> node = stack.pop();
            if (node.left == null && node.right == null)
                count++;
            if (node.left != null)
                stack.add(node.left);
            if (node.right != null)
                stack.add(node.right);
        }
        return count;
    }

    public int getNumberOfNonLeaves() {
        return getSize() - getNumberOfLeaves();
    }

    public static class TreeNode<E extends Comparable<E>> {
        protected E element;
        protected TreeNode<E> left;

        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;
        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }
        return list;
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break;
        }
        if (current == null)
            return false;

        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements Iterator<E> {
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;

        public InorderIterator() {
            inorder();
        }

        private void inorder() {
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            delete(list.get(current));
            list.clear();
            inorder();
        }
    }

    public Iterator<E> preorderIterator() {
        return new PreorderIterator();
    }

    private class PreorderIterator implements Iterator<E> {
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;

        public PreorderIterator() {
            preorder();
        }

        private void preorder() {
            preorder(root);
        }

        private void preorder(TreeNode<E> root) {
            if (root == null) return;
            preorder(root.left);
            preorder(root.right);
            list.add(root.element);
        }

        @Override
        public boolean hasNext() {
            return current < getSize();
        }

        @Override
        public E next() {
            return list.get(current++);
        }
    }

    public boolean equals(BST<E> otherTree) {
        return equals(root, otherTree.root);
    }

    private boolean equals(TreeNode<E> node1, TreeNode<E> node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null) {
            return node1.element.equals(node2.element) &&
                equals(node1.left, node2.left) &&
                equals(node1.right, node2.right);
        }
        return false;
    }

    public BST<E> clone() {
        BST<E> clonedTree = new BST<>();
        clonedTree.size = size;
        clonedTree.root = clone(root);
        return clonedTree;
    }

    private TreeNode<E> clone(TreeNode<E> node) {
        if (node == null)
            return null;
        TreeNode<E> retNode = new TreeNode<>(node.element);
        retNode.left = clone(node.left);
        retNode.right = clone(node.right);
        return retNode;
    }
}