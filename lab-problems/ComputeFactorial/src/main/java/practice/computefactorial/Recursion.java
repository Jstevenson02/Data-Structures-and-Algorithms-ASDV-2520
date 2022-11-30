/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.computefactorial;

/**
 *
 * @author jacob
 */


public class Recursion {
    public static void printArrayRecursevely(int [] ar, int i) {
        if (i== -1) 
            return;
        System.out.println(ar[i]);
        printArrayRecursevely(ar, --i);
        
    }
    public static void main(String[] args) {
        printArrayRecursevely(new int[] {1,2,3},  1);
    }
}
