/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.lab9.chapter20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author jacob
 */
public class A3 {

    int x;

    public A3() {
    }

    public A3(int x) {
        this.x = x;
    }

    public static Comparator<A3> comparatorReverse() {
        Comparator<A3> r = new Comparator<A3>() {

            @Override
            public int compare(A3 o1, A3 o2) {
                return o2.x - o1.x;
            }
        };
        return r;
    }

    public static Comparator<A3> comparator() {
        Comparator<A3> c = new Comparator<A3>() {

            @Override
            public int compare(A3 o1, A3 o2) {
                return o1.x - o2.x;
            }
        };
        return c;
    }

    @Override
    public String toString() {
        return "A3{" + "x = " + x + '}';
    }

    public static void main(String[] args) {
        System.out.println("Sort in ascending order");
        List<A3> list1 = Arrays.asList(new A3(4), new A3(), new A3(2));

        Collections.sort(list1, A3.comparatorReverse());
        System.out.println(list1);
    }
}
