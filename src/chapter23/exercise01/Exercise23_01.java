package chapter23.exercise01;

import java.util.Comparator;

public class Exercise23_01 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[100_000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = (int)(Math.random() * 1200);

        long timeStarted = System.currentTimeMillis();
        bubbleSort(nums);
        long timeEnded = System.currentTimeMillis();
        System.out.println("Executed in " + (timeEnded - timeStarted) + "ms: ");

        for (int i = 0; i < nums.length; i++)
            nums[i] = (int)(Math.random() * 1200);

        timeStarted = System.currentTimeMillis();
        bubbleSort(nums, Integer::compareTo);
        timeEnded = System.currentTimeMillis();
        System.out.println("Executed in " + (timeEnded - timeStarted) + "ms: " );
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length; i++)
            for (int j = list.length - 1; j > i; j--)
                if (list[i].compareTo(list[j]) < 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
    }

    public static <E> void bubbleSort(E[] list, Comparator<E> comparator) {
        for (int i = 0; i < list.length; i++)
            for (int j = list.length - 1; j > i; j--)
                if (comparator.compare(list[i], list[j]) < 0) {
                    E temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
    }
}
