package practice.lab9.chapter20;

import java.util.Arrays;
import java.util.Comparator;

public class SortPointsInPlane {

    public static void main(String[] args) {

        Point[] points = new Point[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
            points[i].x = Math.random() * 100;
            points[i].y = Math.random() * 100;
        }

        points[0].x = 1.03;
        points[0].y = 1.04;
        points[1].x = 1.03;
        points[1].y = 1.03;

        Arrays.sort(points);
        for (Point p : points) {
            System.out.println(p.toString());
        }

        Arrays.sort(points, new CompareY());
        for (Point p : points) {
            System.out.println(p.toString());
        }

    }
}

class Point implements Comparable<Point> {

    public double x, y;

    @Override
    public int compareTo(Point o) {

        if (x > o.x) {
            return 1;
        } else if (x < o.x) {
            return -1;
        } else if (y > o.y) {
            return 1;
        } else if (y < o.y) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "[" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + "]";
    }
}

class CompareY implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {

        if (o1.y > o2.y) {
            return 1;
        } else if (o1.y < o2.y) {
            return -1;
        } else if (o1.x > o2.x) {
            return 1;
        } else if (o1.x < o2.x) {
            return -1;
        } else {
            return 0;
        }
    }
}
