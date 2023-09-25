package chapter24.exercise02;

import chapter24.exercise01.MyAbstractList;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    public MyLinkedList() {
    }

    public MyLinkedList(E[] objects) {
        super(objects);
    }

    @Override
    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size)
            addLast(e);
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node<E> next = current.next;
            current.next = new Node<>(e);
            current.next.next = next;
            size++;
        }
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        while (current != null) {
            E element = current.element;
            if (element.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    public E getFirst() {
        return size == 0 ? null : head.element;
    }

    public E getLast() {
        return size == 0 ? null : tail.element;
    }

    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        node.next = head;
        head = node;
        size++;
        if (tail == null) tail = head;
    }

    public void addLast(E e) {
        Node<E> node = new Node<>(e);
        tail.next = node;
        tail = node;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            return null;
        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.element;
    }

    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        int idx = 0;
        while (current != null) {
            if (current.element.equals(e))
                return idx;
            idx++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> current = head;
        int currentIndex = 0, lastIndex = 0;
        while (current != null) {
            if (current.element.equals(e))
                lastIndex = currentIndex;
            currentIndex++;
            current = current.next;
        }
        return lastIndex;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public Object set(int index, E e) {
       if (index < 0 || index >= size)
           return null;
       Node<E> currentNode = head, previousNode = head;
       for (int i = 0; i < index; i++) {
           previousNode = currentNode;
           currentNode = previousNode.next;
       }
       E previousValue = currentNode.element;
       previousNode.next = new Node<>(e);
       previousNode.next.next = currentNode.next;
       return previousValue;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
