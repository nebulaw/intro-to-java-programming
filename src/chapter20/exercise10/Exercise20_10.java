package chapter20.exercise10;

import java.util.*;

public class Exercise20_10 {
    public static void main(String[] args) {
        PriorityQueue<String> names1 = new PriorityQueue<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        PriorityQueue<String> names2 = new PriorityQueue<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

//        System.out.print("Union: ");
//        for (String word : union(names1, names2))
//            System.out.print(word + " ");
//        System.out.println();

//        System.out.print("Difference: ");
//        for (String word : difference(names1, names2))
//            System.out.print(word + " ");
//        System.out.println();

        System.out.print("Intersection: ");
        for (String word : intersection(names1, names2))
            System.out.print(word + " ");
        System.out.println();

    }

    public static Set<String> union(PriorityQueue<String> q1, PriorityQueue<String> q2) {
        Set<String> union = new HashSet<>();
        while (!q1.isEmpty()) union.add(q1.poll());
        while (!q2.isEmpty()) union.add(q2.poll());
        return union;
    }

    public static Set<String> difference(PriorityQueue<String> q1, PriorityQueue<String> q2) {
        Set<String> difference = new HashSet<>();
        while (!q1.isEmpty())
            difference.add(q1.poll());
        while (!q2.isEmpty()) {
            String word = q2.poll();
            if (!difference.add(word))
                difference.remove(word);
            else difference.add(word);
        }
        return difference;
    }

    public static Set<String> intersection(PriorityQueue<String> q1, PriorityQueue<String> q2) {
        Set<String> intersection = new HashSet<>();
        while (!q2.isEmpty()) {
            String word = q2.poll();
            if (q1.contains(word))
                intersection.add(word);
        }
        return intersection;
    }
}
