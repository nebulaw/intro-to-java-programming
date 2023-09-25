package chapter19.exercise08;


import java.util.ArrayList;
import java.util.Collections;

public class Exercise19_08 {

    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int randomIndex = (int)(Math.round(Math.random() * (list.size() - 1 - i)));
            Collections.swap(list, i, randomIndex);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(23);
        nums.add(23);
        nums.add(2444);
        nums.add(534);
        nums.add(4250);

        shuffle(nums);
        System.out.println(nums);
    }
}
