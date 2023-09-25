package chapter20.exercise04;

public class Point implements Comparable<Point> {
    protected float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x)
            return Double.compare(this.y, o.y);
        return Double.compare(this.x, o.x);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
