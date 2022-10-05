/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.lab5.inclass;

import java.util.Comparator;

public class GeometricObjectComparator
        implements Comparator<GeometricObject> {

    public int compare(GeometricObject o1, GeometricObject o2) {
        return o1.getArea() > o2.getArea()
                ? 1 : o1.getArea() == o2.getArea() ? 0 : -1;
    }
}
