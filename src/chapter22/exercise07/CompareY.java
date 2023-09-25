package chapter22.exercise07;

import java.util.Comparator;

public class CompareY implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return (int) (o1.getY() != o2.getY() ? o1.getY() - o2.getY() : o1.getX() - o2.getX());
    }
}
