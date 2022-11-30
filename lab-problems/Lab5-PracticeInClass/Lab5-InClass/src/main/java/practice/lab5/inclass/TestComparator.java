package practice.lab5.inclass;

import java.util.Comparator;

public class TestComparator {

    public static void main(String[] args) {
        GeometricObject g1 = new Rectangle(5, 5);
        GeometricObject g2 = new Circle(5);

        GeometricObject g
                = max(g1, g2, new GeometricObjectComparator());

        System.out.println("The area of the larger object is "
                + g.getArea());
    }

    public static GeometricObject max(GeometricObject g1,
            GeometricObject g2, Comparator<GeometricObject> c) {
        return c.compare(g1, g2) > 0 ? g1 : g2;
    }
}

class Rectangle extends GeometricObject {

    double w, h;

    Rectangle(double h, double w) {
        this.w = w;
        this.h = h;
    }

    @Override
    public double getArea() {
        return w * h;
    }

    @Override
    public double getPerimeter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Circle extends GeometricObject {

    double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * this.r * this.r;
    }

    @Override
    public double getPerimeter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
