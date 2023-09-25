package chapter19.exercise04;

public class Exercise19_04 {
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++)
            if (list[i].equals(key))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        String[] words = { "odd", "even", "star", "flu", "cat" };

        System.out.println(linearSearch(words, "flu"));

    }
}
