package chapter24.exercise06;

import java.util.Comparator;

public class MyPriorityQueue<E> {
    private Heap<E> heap;

    public MyPriorityQueue(Comparator<E> comparator) {
        this.heap = new Heap<>(comparator);
    }

    public void enqueue(E newObject) {
        heap.add(newObject);
    }

    public E dequeue() {
        return heap.remove();
    }

    public int getSize() {
        return heap.getSize();
    }
}
