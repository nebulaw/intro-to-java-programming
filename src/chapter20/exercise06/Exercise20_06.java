package chapter20.exercise06;

import java.util.LinkedList;
import java.util.List;

public class Exercise20_06 {
    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        for (int i = 0; i < 5E6; i++)
            nums.add((int)(Math.random() * 210));

//        for (int n : nums)
//            System.out.print(n + " ");
//        System.out.println();

        // es dzaan nelia amitom daskvna:
        // ar gamoiyenot linked listebi rodesac amxela
        // informacias vinaxavt da wakitxvis operaciebi
        // ufro metia vidre chaweris.
        for (int i = 0; i < 5E6; i++)
            System.out.print(nums.get(i) + " ");
        System.out.println();
    }
}
