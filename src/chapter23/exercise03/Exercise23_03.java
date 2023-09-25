package chapter23.exercise03;

import java.util.Comparator;

public class Exercise23_03 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[100_000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = (int)(Math.random() * 1200);

        long timeStarted = System.currentTimeMillis();
        quickSort(nums);
        long timeEnded = System.currentTimeMillis();
        System.out.println("Executed in " + (timeEnded - timeStarted) + "ms: ");

        for (int i = 0; i < nums.length; i++)
            nums[i] = (int)(Math.random() * 1200);

        timeStarted = System.currentTimeMillis();
        quickSort(nums, Integer::compareTo);
        timeEnded = System.currentTimeMillis();
        System.out.println("Executed in " + (timeEnded - timeStarted) + "ms: " );
    }

    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    private static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        E pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {
            while (low <= high && list[low].compareTo(pivot) <= 0) low++;
            while (low <= high && list[high].compareTo(pivot) > 0) high--;
            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high].compareTo(pivot) >= 0)
            high--;
        if (pivot.compareTo(list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }


    public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        quickSort(list, 0, list.length - 1, comparator);
    }

    private static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
        if (last > first) {
            int pivotIndex;
            E pivot = list[first];
            int low = first + 1;
            int high = last;
            while (high > low) {
                while (low <= high && comparator.compare(list[low], pivot) <= 0) low++;
                while (low <= high && comparator.compare(list[high], pivot) > 0) high--;
                if (high > low) {
                    E temp = list[high];
                    list[high] = list[low];
                    list[low] = temp;
                }
            }

            while (high > first && comparator.compare(list[high], pivot) >= 0)
                high--;
            if (comparator.compare(pivot, list[high]) > 0) {
                list[first] = list[high];
                list[high] = pivot;
                pivotIndex = high;
            } else pivotIndex = first;

            quickSort(list, first, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, last, comparator);
        }
    }
}
