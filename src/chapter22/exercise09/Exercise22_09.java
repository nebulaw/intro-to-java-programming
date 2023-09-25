package chapter22.exercise09;

// ref: https://www.geeksforgeeks.org/convex-hull-using-jarvis-algorithm-or-wrapping/


import chapter22.exercise07.Point;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise22_09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many points are in the set? ");
        int n = in.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++)
            points[i] = new Point(in.nextDouble(), in.nextDouble());

        ArrayList<Point> hull = convexHull(points);
        System.out.println("Convex hull: ");
        for (Point point : hull)
            System.out.print(point + " ");
        System.out.println();
    }

    private static int orientation(Point p, Point q, Point r) {
        double var1 = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY());
        return var1 == 0 ? 0 : var1 > 0 ? 1 : 2;
    }

    public static ArrayList<Point> convexHull(Point[] points) {
        ArrayList<Point> hull = new ArrayList<>();

        // find leftmost point
        int l = 0;
        for (int i = 0; i < points.length; i++)
            if (points[i].getX() < points[l].getX()) l = i;

        int p = l, q;
        do {
            hull.add(points[p]);
            q = (p + 1) % points.length;
            for (int i = 0; i < points.length; i++)
                if (orientation(points[p], points[i], points[q]) == 2)
                    q = i;
            p = q;
        } while (p != l);

        return hull;
    }
}
