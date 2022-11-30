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
public class OccurancesOfChar {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        System.out.print("Enter a character: ");
        char ch = input.nextLine().charAt(0);
        int times = count(s, ch);
        System.out.print(ch + " appears " + times + (times > 1 ? " times " : " time ") + "in " + s);
    }

    private static int count(String s, char ch) {
        int result = 0;
        if (s.length() > 0) {
            result = count(s.substring(1), ch) + ((s.charAt(0) == ch) ? 1 : 0);
        }
        return result;
    }
}
