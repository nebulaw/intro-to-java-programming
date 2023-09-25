package chapter19.exercise05;

public class Exercise19_05 {
    public static <E extends Comparable<E>> E max(E[] list) {
        if (list.length == 0)
            return null;
        E max = list[0];
        for (int i = 1; i < list.length; i++)
            if (list[i].compareTo(max) > 0)
                max = list[i];
        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(new Integer[]{ 4, 2, 12, 90 }));
    }
}
