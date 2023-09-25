package chapter22.exercise24;

public class Exercise22_24 {
    public static void main(String[] args) {
        int[] numbers = { 40, 4, 5, 12, 89, -120, 120 };
        System.out.println(findSmallest(numbers));
    }

    public static int findSmallest(int[] numbers) {
        return findSmallest(numbers, 0, numbers.length - 1);
    }

    private static int findSmallest(int[] numbers, int low, int high) {
        if (low + 1 == high)
            return Math.min(numbers[low], numbers[high]);
        if (low == high)
            return numbers[low];
        int middle = (low + high) / 2;
        int leftMin = findSmallest(numbers, low, middle);
        int rightMin = findSmallest(numbers, middle + 1, high);
        return Math.min(leftMin, rightMin);
    }
}
