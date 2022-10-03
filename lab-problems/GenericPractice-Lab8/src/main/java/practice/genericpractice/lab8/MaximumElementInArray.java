/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.genericpractice.lab8;

import static java.lang.Math.E;

/**
 *
 * @author jacob
 */
public class MaximumElementInArray {

    /**
     *
     * @param <E>
     * @param list
     * @return
     */
    public static <E extends Comparable<E>> E max(E[] list) {

        if (list.length == 0 || null == list) {
            throw new RuntimeException("The list is zero or null");
        }

        E max = list[0];

        for (int i = 0; i < list.length; ++i) {
            if (list[i].compareTo(max) > 0) {
                max = list[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] ar1 = {1, 2, 3, 4, 4, 5, 5};
        String[] ar2 = {"a", "b", "b", "c", "c"};
        B[] ar3 = {new B(2), new B(2)};

        System.out.println(max(ar1));
        System.out.println(max(ar2));
        System.out.println(max(ar3));
    }
}

class B implements Comparable<B> {

    int x;

    public B(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final B other = (B) obj;
        return this.x == other.x;
    }

    @Override
    public String toString() {
        return "A{" + "x=" + x + '}';
    }

    @Override
    public int compareTo(B o) {
        // Compare to checks for duplicates 
        return this.x - x;
    }
}
