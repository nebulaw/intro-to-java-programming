package chapter24.exercise03;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayLinkedList<E> extends AbstractSequentialList<E> {
  private MyDoublyLinkedList<E> list;
  private Node<E> head, tail;

  protected int size;

  public TwoWayLinkedList() {
    size = 0;
  }

  protected TwoWayLinkedList(E[] objects) {
    for (E object : objects)
      add(object);
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
      current.next.previous = current;
      current.next.next = next;
      current.next.next.previous = current.next;
      size++;
    }
  }

  @Override
  public void clear() {
    size = 0;
    head = tail = null;
  }

  public boolean contains(Object e) {
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

  public E get(int index) {
    if (index < 0 || index >= size)
      return null;
    Node<E> current = head;
    for (int i = 0; i < index; i++)
      current = current.next;
    return current.element;
  }

  public int indexOf(Object e) {
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

  public int lastIndexOf(Object e) {
    Node<E> current = tail;
    int currentIndex = size - 1;
    while (current != null) {
      if (current.element.equals(e))
        return currentIndex;
      currentIndex--;
      current = current.previous;
    }
    return -1;
  }

  public E remove(int index) {
    Node<E> current = head;
    int currentIndex = 0;
    for (int i = 0; i < index; i++)
      current = current.next;
    E retVal = current.element;
    current.next.previous = current.previous;
    current.previous.next = current.next;
    size--;
    return retVal;
  }

  @Override
  public E set(int index, E e) {
    if (index < 0 || index >= size())
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

  private class LinkedListIterator implements ListIterator<E> {
    private Node<E> current = head;
    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      currentIndex++;
      return e;
    }

    @Override
    public boolean hasPrevious() {
      return current.previous != null;
    }

    @Override
    public E previous() {
      E e = current.element;
      current = current.previous;
      currentIndex--;
      return e;
    }

    @Override
    public int nextIndex() {
      return currentIndex + 1;
    }

    @Override
    public int previousIndex() {
      return currentIndex - 1;
    }

    @Override
    public void remove() {
      if (current.previous == null)
        current.next.previous = null;
    }

    @Override
    public void set(E e) {
      current.next = new Node<>(e);
      current.next.previous = current;
      current = current.next;
      currentIndex++;
    }

    @Override
    public void add(E e) {
      current.next = new Node<>(e);
      current.next.previous = current;
    }
  }

  private static class Node<E> {
    E element;
    Node<E> next, previous;

    public Node(E e) {
      element = e;
    }
  }

  @Override
  public ListIterator<E> listIterator(int i) {
    ListIterator<E> it = new LinkedListIterator();
    for (int j = 0; j < i && it.hasNext(); j++)
      it.next();
    return it;
  }

  @Override
  public int size() {
    return list.size();
  }
}
