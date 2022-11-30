package com.mycompany.mp2.recursion;

import java.util.Scanner;


public class StringPermutation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        System.out.println("The permutation for " + s + " is");
        displayPermutation(s);
    }

    public static void displayPermutation(String s)
    {
        displayPermutation(s, "");
    }

    public static void displayPermutation(String s1, String s2) {
        if (s1.length() == 0) {
            System.out.print(s2 + " ");
            return;
        }

        for (int i = 0; i < s1.length(); i++) {

            char ch = s1.charAt(i);

            String ros = s1.substring(0, i) + s1.substring(i + 1);

            displayPermutation(ros, s2 + ch);
        }
    }
}
