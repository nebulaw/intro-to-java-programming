package chapter19.exercise07;

public class Exercise19_07 {
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int left = 0, right = list.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (key.compareTo(list[middle]) < 0)
                right = middle - 1;
            else if (key.compareTo(list[middle]) > 0)
                left = middle + 1;
            else return middle;
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] { 12, 45, 65, 122 };
        System.out.println(binarySearch(nums, 12));
    }
}
