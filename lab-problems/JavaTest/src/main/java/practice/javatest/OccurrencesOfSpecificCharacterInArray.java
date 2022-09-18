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
public class OccurrencesOfSpecificCharacterInArray {

    public static void main(String[] args) {
        System.out.print("Enter an string: ");
        Scanner input = new Scanner(System.in);
        String i = input.next();
        char[] items = i.toCharArray();

        System.out.print("Enter a character: ");
        char ch = input.next().trim().charAt(0);
        System.out.print(ch + " appears " + count(items, ch) + " times!");

        count(new char[]{'h', 'e', 'l', 'l', 'o'}, 'i', 4);
    }

    private static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    public static int count(char[] chars, char ch, int high) {

        if (high < 0) {
            return 0;
        }

        int sum = count(chars, ch, high - 1);

        if (chars[high] == ch) {
            ++sum;
        }
        return sum;
    }
}
