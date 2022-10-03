/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.genericpractice.lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jacob
 */
public class DistinctElementsInArrayList {

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ar1 = (ArrayList<Integer>) Arrays.asList(new Integer[]{1, 2, 3, 4, 4, 5, 5});
        ArrayList<String> ar2 = (ArrayList<String>) Arrays.asList(new String[]{"a", "b", "b", "c", "c"});
        ArrayList<A> ar3 = (ArrayList<A>) Arrays.asList(new A[]{new A(1), new A(2), new A(2)});

        System.out.println(removeDuplicates(ar1));
        System.out.println(removeDuplicates(ar2));
        System.out.println(removeDuplicates(ar3));

    }
}

class A {

    int x;

    public A(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "A{" + "x=" + x + '}';
    }
}
