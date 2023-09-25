package util;


import chapter10.exercise04.MyPoint;

public class MiniMath {
    public static final double PI = 3.141592653589793;

    private MiniMath() {}

    public static double pow(double number, double base) {
        if (base <= 0) return 1;
        if (base == 1) return number;
        return number * pow(number, base - 1);
    }

    public static long powTwo(int power) {
        return (1L << power);
    }

    public static double sqrt(double number) {
        return Math.pow(number, 0.5);
    }

    public static boolean inRange(double value, double min, double max) {
        return Math.min(min, max) <= value && value <= Math.max(min, max);
    }

    public static boolean rangeOverlap(double x0, double y0, double x1, double y1) {
        return Math.min(x1, y1) <= Math.max(x0, y0) &&
          Math.min(x0, y0) <= Math.max(x1, y1);
    }

    public static boolean linesOverlap(MyPoint p1, MyPoint p2, MyPoint p3, MyPoint p4) {
        return lineOverlapsLine(p1, p2, p3, p4) || lineOverlapsLine(p3, p4, p1, p2);
    }

    public static boolean lineOverlapsLine(MyPoint p1, MyPoint p2, MyPoint p3, MyPoint p4) {
        return (Math.min(p1.getX(), p2.getX()) <= Math.min(p3.getX(), p4.getX()) &&
          Math.max(p3.getX(), p4.getX()) <= Math.max(p1.getX(), p2.getX())) ||
          (Math.min(p1.getY(), p2.getY()) <= Math.min(p3.getY(), p4.getY()) &&
            Math.max(p3.getY(), p4.getY()) <= Math.max(p1.getY(), p2.getY()));
    }

    public static void insertionSort(double[] list) {
        for (int i = 1; i < list.length; i++) {
            double currElement = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > list[i]; j--)
                list[j + 1] = list[j];
            list[j + 1] = currElement;
        }
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currElement = list[i];
            int j = 0;
            for (j = i - 1; j >= 0 && list[j] > currElement; j--)
                list[j + 1] = list[j];
            list[j + 1] = currElement;
        }
    }

    public static void bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++)
            for (int j = list.length - 1; j > i; j--)
                if (list[j] < list[i]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = list[i];
                }
    }

    public static void mergeSort(int[] list) {
        if (list.length < 2) return;
        int[] firstHalf = new int[list.length/2];
        System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
        mergeSort(firstHalf);

        int secondHalfLength = list.length - list.length / 2;
        int[] secondHalf = new int[secondHalfLength];
        System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
        mergeSort(secondHalf);
        merge(firstHalf, secondHalf, list);
    }

    private static void merge(int[] list1, int[] list2, int[] temp) {
        int i = 0, j = 0, k = 0;
        while (i < list1.length && j < list2.length)
            if (list1[i] < list2[j]) temp[k++] = list1[i++];
            else temp[k++] = list2[j++];
        while (i < list1.length) temp[k++] = list1[i++];
        while (j < list1.length) temp[k++] = list2[j++];
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIdx = partition(list, first, last);
            quickSort(list, first, pivotIdx - 1);
            quickSort(list, pivotIdx + 1, last);
        }
    }

    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {
            while (low <= high && list[low] <= pivot)
                low++;
            while (low <= high && list[high] > pivot)
                high--;

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
        }
        return first;
    }

}
