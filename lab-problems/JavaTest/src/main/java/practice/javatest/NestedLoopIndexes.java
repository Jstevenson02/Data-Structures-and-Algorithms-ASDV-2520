/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.javatest;

/**
 *
 * @author jacob
 */
public class NestedLoopIndexes {

    final static int ROWS = 3;
    final static int COLUMNS = 3;

    public static void nestedLoopsIndexesR(int i, int j) {
        if (j == COLUMNS) {
            System.out.println("");
            return;
        }
        if (i == ROWS) {
            return;
        }
        System.out.print(i + ", " + j + "   ");
        nestedLoopsIndexesR(i, ++j);

        if (i + 1 == j) {
            nestedLoopsIndexesR(++i, 0);
        }
    }

    public static void main(String[] args) {
        nestedLoopsIndexesR(0, 0);
    }
}
