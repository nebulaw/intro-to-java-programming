package chapter19.exercise06;

public class Exercise19_06 {
    public static <E extends Comparable<E>> E max(E[][] list) {
        if (list.length == 0)
            return null;
        if (list[0].length == 0)
            return null;
        E max = list[0][0];
        for (E[] es : list)
            for (int j = 1; j < es.length; j++)
                if (es[j].compareTo(max) > 0)
                    max = es[j];
        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(new Integer[][]{
                new Integer[] { 2, 42, 200 },
                new Integer[] { 210, 400, 1200, 5060021 },
                new Integer[] {},
        }));
        System.out.println(max(new Integer[][] {}));
    }
}
