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
public class UpperCaseInArray {

    public static void main(String[] args) {
        System.out.print("Enter an string: ");
        Scanner input = new Scanner(System.in);
        String i = input.next();
        char[] items = i.toCharArray();
        System.out.print("The number of uppercase letters is " + count(items));
        System.out.println("");
    }

    private static int count(char[] chars) {
        return count(chars, chars.length - 1);
    }

    public static int count(char[] chars, int high) {
        if (high >= 0) {
            int sum = count(chars, high - 1) + (Character.isUpperCase(chars[high]) ? 1 : 0);
            return sum;
        } else {
            return 0;
        }
    }
}
