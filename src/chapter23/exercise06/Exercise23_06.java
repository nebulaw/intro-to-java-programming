package chapter23.exercise06;

import java.util.Comparator;

public class Exercise23_06 {
    public static void main(String[] args) {

    }

    public static boolean ordered(int[] list) {
        for (int i = 0; i < list.length - 1; i++)
            if (list[i] > list[i + 1])
                return false;
        return true;
    }

    public static boolean ordered(int[] list, boolean ascending) {
        for (int i = 0; i < list.length - 1; i++) {
            if (ascending) {
                if (list[i] > list[i + 1])
                    return false;
            } else {
                if (list[i] < list[i + 1])
                    return false;
            }
        }
        return true;
    }

    public static boolean ordered(double[] list) {
        for (int i = 0; i < list.length - 1; i++)
            if (list[i] > list[i + 1])
                return false;
        return true;
    }

    public static boolean ordered(double[] list, boolean ascending) {
        for (int i = 0; i < list.length - 1; i++) {
            if (ascending) {
                if (list[i] > list[i + 1])
                    return false;
            } else {
                if (list[i] < list[i + 1])
                    return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> boolean ordered(E[] list) {
        for (int i = 0; i < list.length - 1; i++)
            if (list[i].compareTo(list[i + 1]) < 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> boolean ordered(E[] list, boolean ascending) {
        for (int i = 0; i < list.length - 1; i++) {
            if (ascending) {
                if (list[i].compareTo(list[i + 1]) < 0)
                    return false;
            } else {
                if (list[i].compareTo(list[i + 1]) > 0)
                    return false;
            }
        }
        return true;
    }

    public static <E> boolean ordered(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++)
            if (comparator.compare(list[i], list[i + 1]) < 0)
                return false;
        return true;
    }

    public static <E> boolean ordered(E[] list, Comparator<? super E> comparator, boolean ascending) {
        for (int i = 0; i < list.length - 1; i++) {
            if (ascending) {
                if (comparator.compare(list[i], list[i + 1]) < 0)
                    return false;
            } else {
                if (comparator.compare(list[i], list[i + 1]) > 0)
                    return false;
            }
        }
        return true;
    }
}
