/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.genericpractice.lab8;

/**
 *
 * @author jacob
 */
public class GenericBinarySearch {

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int min = 0;
        int max = list.length - 1;

        while (max >= min) {
            int mid = (max - min) / 2 + min;
            if (list[mid].compareTo(key) == 0) {
                return mid;
            }

            if (list[mid].compareTo(key) < 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return -1;
    }
}
