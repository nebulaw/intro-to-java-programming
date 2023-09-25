package chapter22.exercise07;

public class Point implements Comparable<Point> {
    private double x, y;

    public Point() {
        x = y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public double distance(Point other) {
        return distance(other.x, other.y);
    }

    public double distance(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point))
            return false;
        return this.x == ((Point)other).x && this.y == ((Point)other).y;
    }

    @Override
    public int compareTo(Point o) {
        int retVal;
        if ((retVal = Double.compare(this.x, o.x)) == 0)
            return Double.compare(this.y, o.y);
        return retVal;
    }

    public String toString() {
        return String.format("(%.3f, %.3f)", x, y);
    }
}
