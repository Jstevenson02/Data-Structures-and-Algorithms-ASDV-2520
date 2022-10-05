/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.genericpractice.lab8;

import java.util.ArrayList;

/**
 *
 * @author jacob
 */
public class SortArrayList {

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        E min;
        int minIndex;

        for (int i = 0; i < list.size() - 1; i++) {
            min = list.get(i);
            minIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (min.compareTo(list.get(j)) > 0) {
                    min = list.get(j);
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                list.set(minIndex, list.get(i));
                list.set(i, min);
            }
        }
    }
}
