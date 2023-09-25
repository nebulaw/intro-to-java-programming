package chapter19.exercise10;

import java.util.ArrayList;

public class Exercise19_10 {
    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        if (list.isEmpty())
            return null;
        E max = list.get(0);
        for (E o : list)
            if (o.compareTo(max) > 0)
                max = o;
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(23);
        nums.add(23);
        nums.add(2444);
        nums.add(534);
        nums.add(4250);

        System.out.println(max(nums));
    }
}
