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
public class A2 {

    int x;

    public A2() {
    }

    public A2(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "A2{" + "x = " + x + '}';
    }

    public static void main(String[] args) {
        System.out.println("Sort in ascending order");
        List<A2> list1 = Arrays.asList(new A2(4), new A2(), new A2(2));

        // Does not impliment comparable so we create COMPARATOR object type
        Comparator<A2> c = new Comparator<A2>() {
            @Override
            public int compare(A2 o1, A2 o2) {
                return o1.x - o2.x;
            }
        };

        // Reverse order sort using new COMPARATOR object type
        Comparator<A2> r = new Comparator<A2>() {
            @Override
            public int compare(A2 o1, A2 o2) {
                return o2.x - o1.x;
            }
        };

        Collections.sort(list1, c);
        System.out.println(list1);

        System.out.println("Sort in descending order");
        Collections.sort(list1, r);
        System.out.println(list1);

    }
}
