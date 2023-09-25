package chapter19.exercise03;

import chapter19.exercise02.GenericStack;

import java.util.ArrayList;

public class Exercise19_03 {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        GenericStack<E> visited = new GenericStack<>();
        for (E o : list)
            if (!visited.contains(o))
                visited.push(o);
        return visited;
    }

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        lines.add("never");
        lines.add("never");
        lines.add("desire");
        lines.add("hunger");
        lines.add("desire");

        lines = removeDuplicates(lines);
        System.out.println(lines);
    }
}
