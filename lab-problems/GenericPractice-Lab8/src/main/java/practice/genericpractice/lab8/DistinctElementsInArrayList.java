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

        for (int i = 0; i < list.size() - 1; i++) {
            {
                E toBeremoved = list.get(i);

                for (int j = i + 1; j < list.size(); ++j) {
                    if (list.get(j).equals(list.get(i))) {
                        list.remove(j);
                        break;
                    }

                }

            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ar1 = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 4, 5, 5}));
        ArrayList<String> ar2 = new ArrayList<>(Arrays.asList(new String[]{"a", "b", "b", "c", "c"}));
        ArrayList<B> ar3 = new ArrayList<B>(Arrays.asList(new B[]{new B(1), new B(2), new B(2)}));

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
        final A other = (A) obj;
        return this.x == other.x;
    }

    @Override
    public String toString() {
        return "A{" + "x=" + x + '}';
    }
}
