/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.javatest;

import java.util.Scanner;

/**
 *
 * @author jacob
 */
public class ReverseInt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int i = input.nextInt();
        System.out.println("The reversal of  " + i + " is ");
        reverseDisplay(i);
        System.out.println("");
    }

    private static void reverseDisplay(int i) {
        if (i != 0) {
            System.out.print(i % 10);
            i = i / 10;
            reverseDisplay(i);
        }
    }
}
