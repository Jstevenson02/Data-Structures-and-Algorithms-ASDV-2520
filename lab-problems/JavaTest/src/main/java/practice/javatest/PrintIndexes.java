/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.javatest;

/**
 *
 * @author jacob
 */
public class PrintIndexes {

    public static void printIndexesOfArrayAndElementR(int[] ar, int index) {
        if (index == ar.length) {
            return;
        }
        System.out.println(index + ", " + ar[index] + " ");
        printIndexesOfArrayAndElementR(ar, ++index);
    }

    public static void printIndexesOfArrayAndElementFromEndToFront(int[] ar, int index) {
        if (index == ar.length - 1) {
            return;
        }
        printIndexesOfArrayAndElementFromEndToFront(ar, ++index);
        System.out.print(index - 1 + ", " + ar[index - 1] + " ");

    }

    public static void main(String[] args) {
        printIndexesOfArrayAndElementFromEndToFront(new int[]{10, 20, 30}, 0);
    }

}
