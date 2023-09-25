package chapter19.exercise09;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise19_09 {
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++)
            for (int j = list.size() - 1; j > i; j--)
                if (list.get(i).compareTo(list.get(j)) > 0)
                    Collections.swap(list, i, j);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(23);
        nums.add(23);
        nums.add(2444);
        nums.add(534);
        nums.add(4250);

        sort(nums);
        System.out.println(nums);
    }
}
