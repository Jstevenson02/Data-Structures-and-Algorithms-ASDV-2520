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
public class A4<E extends Comparable<E>> {

    E x;

    public A4() {
    }

    public A4(E x) {
        this.x = x;
    }

    public static Comparator<A4> comparator() {
        Comparator<A4> c;
        c = new Comparator<A4>() {

            @Override
            public int compare(A4 a1, A4 a2) {
                return a1.x.compareTo(a2.x);
            }
        };
        return c;
    }

    public static Comparator<A4> comparatorReverse() {
        Comparator<A4> c;
        c = new Comparator<A4>() {

            @Override
            public int compare(A4 a1, A4 a2) {
                return a2.x.compareTo(a1.x);
            }
        };
        return c;
    }

    @Override
    public String toString() {
        return "A4{" + "x = " + x + '}';
    }

    public static void main(String[] args) {
        System.out.println("Sort in ascending order");
        List<A4> list1 = Arrays.asList(new A4(new Integer(4)), new A4(new Integer(1)), new A4(new Integer(2)));
        Collections.sort(list1, A4.comparator());
      //  System.out.println(list1);

        List<A4> list2 = Arrays.asList(
                new A4(new String("once")),
                new A4(new String("upon")),
                new A4(new String("a")),
                new A4(new String("time")),
                new A4(new String("in")),
                new A4(new String("America"))
        );
        Collections.sort(list2, A4.comparator());
        System.out.println(list2);

        Collections.sort(list1, A4.comparatorReverse());
        Collections.sort(list2, A4.comparatorReverse());
        System.out.println(list1);
        System.out.println(list2);
    }
}
