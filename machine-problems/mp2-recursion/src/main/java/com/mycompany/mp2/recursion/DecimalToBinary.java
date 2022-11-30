package com.mycompany.mp2.recursion;

import java.util.Scanner;

public class DecimalToBinary {

    static String output = "";

    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a decimal integer: ");
            int decimal = input.nextInt();
            System.out.println(decimal + " is binary " + decimalToBinary(decimal));
        }

    }

    public static String decimalToBinary(int value) {

        if (value <= 1) {
            output += (char) (value + '0');
        } else {
            decimalToBinary(value / 2);
            if (value % 2 != 0) {
                output += '1';
            } else {
                output += '0';
            }
        }
        return output;
    }
}
