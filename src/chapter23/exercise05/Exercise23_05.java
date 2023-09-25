package chapter23.exercise05;

import util.Heap;

import java.util.Comparator;

public class Exercise23_05 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[100_000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = (int)(Math.random() * 1200);

        long timeStarted = System.currentTimeMillis();
        heapSort(nums);
        long timeEnded = System.currentTimeMillis();
        System.out.println("Executed in " + (timeEnded - timeStarted) + "ms: ");

        for (int i = 0; i < nums.length; i++)
            nums[i] = (int)(Math.random() * 1200);

        timeStarted = System.currentTimeMillis();
        heapSort(nums, Integer::compareTo);
        timeEnded = System.currentTimeMillis();
        System.out.println("Executed in " + (timeEnded - timeStarted) + "ms: " );
    }

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        Heap<E> heap = new Heap<>();
        for (E e : list) heap.add(e);
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
        HeapCmp<E> heapCmp = new HeapCmp<>(comparator);
        for (E e : list) heapCmp.add(e);
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heapCmp.remove();
    }

}
