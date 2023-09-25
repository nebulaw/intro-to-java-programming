package chapter20.exercise04;

import java.util.Arrays;

public class Exercise20_04 {
    public static void main(String[] args) {

        Point[] points = new Point[100];
        for (int i = 0; i < points.length; i++)
            points[i] = new Point((float)(Math.random() * 100), (float)(Math.random() * 100));

        Arrays.sort(points);

        for (Point point : points)
            System.out.print(point + " ");
        System.out.println();

        Arrays.sort(points, new CompareY());
        for (Point point : points)
            System.out.print(point + " ");
        System.out.println();
    }
}
