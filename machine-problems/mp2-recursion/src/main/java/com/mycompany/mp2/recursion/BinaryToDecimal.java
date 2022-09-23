package com.mycompany.mp2.recursion;

import java.util.Scanner;

public class BinaryToDecimal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.print("Enter a binary number: ");

            String binary = input.nextLine();

            System.out.println(binary + " is decimal " + binaryToDecimal(binary));
        }
    }

    public static int binaryToDecimal(String binaryString) {
        int low = 0;
        int high = binaryString.length() - 1;
        int result = 0;
        return binaryToDecimal(binaryString, low, high, result);
    }

    public static int binaryToDecimal(String binaryString, int low, int high, int result) {

        result += (Integer.parseInt(binaryString.charAt(low) + "") * (int) Math.pow(2, high));
        
        if (high == 0) {
            return result;

        } else {
            return binaryToDecimal(binaryString, low + 1, high - 1, result);
        }
    }
}
