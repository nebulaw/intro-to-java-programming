package chapter23.exercise02;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise23_02 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[100_000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = (int)(Math.random() * 1200);

        long timeStarted = System.currentTimeMillis();
        mergeSort(nums);
        long timeEnded = System.currentTimeMillis();
        System.out.println("Executed in " + (timeEnded - timeStarted) + "ms: ");

        for (int i = 0; i < nums.length; i++)
            nums[i] = (int)(Math.random() * 1200);

        timeStarted = System.currentTimeMillis();
        mergeSort(nums, Integer::compareTo);
        timeEnded = System.currentTimeMillis();
        System.out.println("Executed in " + (timeEnded - timeStarted) + "ms: " );
    }

    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length < 2) return;
        E[] left = Arrays.copyOf(list, list.length / 2);
        System.arraycopy(list, 0, left, 0, list.length / 2);
        mergeSort(left);

        int rightSize = list.length - list.length / 2;
        E[] right = Arrays.copyOf(list, rightSize);
        System.arraycopy(list, list.length / 2,
                right, 0, rightSize);
        mergeSort(right);

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0)
                list[k++] = left[i++];
            else
                list[k++] = right[j++];
        }

        while (i < left.length)
            list[k++] = left[i++];

        while (j < right.length)
            list[k++] = right[j++];
    }

    public static <E> void mergeSort(E[] list, Comparator<E> comparator) {
        if (list.length < 2) return;
        E[] left = Arrays.copyOf(list, list.length / 2);
        System.arraycopy(list, 0, left, 0, list.length / 2);
        mergeSort(left, comparator);

        int rightSize = list.length - list.length / 2;
        E[] right = Arrays.copyOf(list, rightSize);
        System.arraycopy(list, list.length / 2,
                right, 0, rightSize);
        mergeSort(right, comparator);

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length)
            if (comparator.compare(left[i], right[j]) < 0)
                list[k++] = left[i++];
            else
                list[k++] = right[j++];

        while (i < left.length)
            list[k++] = left[i++];

        while (j < right.length)
            list[k++] = right[j++];
    }
}
