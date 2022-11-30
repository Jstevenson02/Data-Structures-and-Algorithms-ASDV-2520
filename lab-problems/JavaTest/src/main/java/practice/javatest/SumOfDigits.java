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
public class SumOfDigits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an Integer: ");
        int i = input.nextInt();
        System.out.println("The sum  of digits in " + i + " is " + sumDigits(i));
        System.out.println("");
    }

    private static int sumDigits(int i) {
        if (i == 0) {
            return 0;
        }
        return i % 10 + sumDigits(i / 10);
    }
}
