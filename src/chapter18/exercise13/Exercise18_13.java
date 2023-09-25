package chapter18.exercise13;

/**
 * Write a recursive method that returns the
 * largest integer in an array. Write a test program that prompts the user to enter a
 * list of eight integers and displays the largest element.
 * */

public class Exercise18_13 {
    public static int max(int[] array) {
        return max(array, 1, array[0]);
    }

    public static int max(int[] array, int i, int lastMax) {
        if (i == array.length)
            return lastMax;
        return max(array, i + 1, Math.max(array[i], lastMax));
    }

    public static void main(String[] args) {
        int[] array = { 4, 5, 1, 4, 20, -199, 245, 200, 45602, 2 };

        System.out.println("Max is " + max(array));
    }
}
