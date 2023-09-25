package chapter23.exercise04;

import util.MiniMath;

public class Exercise23_04 {
    public static void main(String[] args) {
        int[] nums = new int[100_000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = (int)(Math.random() * 1200);

        long timeStarted = System.currentTimeMillis();
        quickSort(nums);
        long timeEnded = System.currentTimeMillis();
        System.out.println("Executed in " + (timeEnded - timeStarted) + "ms: ");
    }

    public static void quickSort(int[] list) {
        quickSort(list, middleOf(list), list.length - 1);
    }

    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {
            while (low <= high && list[low] <= pivot) low++;
            while (low <= high && list[high] > pivot) high--;
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high] >= pivot)
            high--;
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    private static int middleOf(int[] list) {
        int[] temp = {list[0], list[list.length / 2], list[list.length - 1]};
        MiniMath.mergeSort(temp);
        if (list[0] == temp[1]) {
            return 0;
        }
        else if (list[list.length / 2] == temp[1]) {
            return list.length / 2;
        }

        return list.length - 1;
    }
}
