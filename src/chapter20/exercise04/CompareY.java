package chapter20.exercise04;

import java.util.Comparator;

public class CompareY implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        if (o1.x == o2.x)
            return Double.compare(o1.y, o2.y);
        return Double.compare(o1.x, o2.x);
    }
}
