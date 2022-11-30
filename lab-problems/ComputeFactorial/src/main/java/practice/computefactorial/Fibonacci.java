/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.computefactorial;

import java.util.Scanner;

/**
 *
 * @author jacob
 */
public class Fibonacci {

    public static long fibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3)
        {
            return 2;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Which fibonacci base number?");
        int n = new Scanner(System.in).nextInt();
        System.out.println(fibonacci(n));
    }

}
