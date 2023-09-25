package chapter22.exercise07;


import util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise22_07 {
    public static void main(String[] args) {
        Point[] points = new Point[] {
                new Point(4.5, 2.1),
                new Point(6.7, 3.4),
                new Point(24.4, 2.71),
        };
        System.out.println("pair: " + getClosestPair(points));
    }

    public static Pair<Point, Point> getClosestPair(double[][] points) {
        Point[] ps = new Point[points.length];
        for (int i = 0; i < points.length; i++)
            ps[i] = new Point(points[i][0], points[i][0]);
        return getClosestPair(ps);
    }

    public static Pair<Point, Point> getClosestPair(Point[] points) {
        Point[] pointsY = points.clone();
        Arrays.sort(points);
        Arrays.sort(pointsY, new CompareY());
        return distance(points, 0, points.length - 1, pointsY);
    }

    public static Pair<Point, Point> distance(Point[] pointsOrderedOnX, int low, int high, Point[] pointsOrderedOnY) {
        if (high <= low)
            return null;
        else if (low == high - 1)
            return new Pair<>(pointsOrderedOnX[low], pointsOrderedOnX[high]);
        int middle = (low + high) / 2;
        Pair<Point, Point> leftPoint = distance(pointsOrderedOnX, low, middle, pointsOrderedOnY);
        Pair<Point, Point> rightPoint = distance(pointsOrderedOnX, middle + 1, high, pointsOrderedOnY);
        Pair<Point, Point> retPair = null;
        double distance = 0;

        if (leftPoint != null && rightPoint != null) {
            double leftDistance = leftPoint.getKey().distance(leftPoint.getValue());
            double rightDistance = rightPoint.getKey().distance(rightPoint.getValue());
            retPair = Math.min(leftDistance, rightDistance) == leftDistance ? leftPoint : rightPoint;
            distance = Math.min(leftDistance, rightDistance);
        } else if (leftPoint != null) {
            distance = leftPoint.getKey().distance(leftPoint.getValue());
            retPair = leftPoint;
        } else if (rightPoint != null) {
            distance = rightPoint.getKey().distance(rightPoint.getValue());
            retPair = rightPoint;
        }

        List<Point> lefts = new ArrayList<>();
        List<Point> rights = new ArrayList<>();
        for (Point point : pointsOrderedOnY) {
            if (point.getX() <= pointsOrderedOnY[middle].getX() &&
                    pointsOrderedOnY[middle].getX() - point.getX() <= distance)
                lefts.add(point);
            else if (point.getX() > pointsOrderedOnX[middle].getX() &&
                    point.getX() - pointsOrderedOnX[middle].getX() <= distance)
                rights.add(point);
        }

        int i = 0, j = 0;
        for (Point point : lefts) {
            while (i < rights.size() && rights.get(i).getY() <= point.getY() - distance)
                i++;
            j = i;
            while (j < rights.size() && Math.abs(rights.get(j).getY() - point.getY()) <= distance) {
                Pair<Point, Point> p = new Pair<>(point, rights.get(j));
                double tempDistance = p.getKey().distance(p.getValue());
                if (tempDistance < distance) {
                    distance = tempDistance;
                    p.setKey(point);
                    p.setValue(rights.get(j));
                }
                j++;
            }
        }

        return retPair;
    }

}
