/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab11.bigo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacob
 */
public class TwentyTwoPointSix {

    public static List<Integer> findFibonacciList(int fib) {
        int n1 = 0;
        int n2 = 1;
        int n3;

        List<Integer> fibList = new ArrayList<>();
        fibList.add(n1);
        fibList.add(n2);

        for (int i = 2; i < fib; ++i) {
            n3 = n1 + n2;
            fibList.add(n3);
            n1 = n2;
            n2 = n3;
        }
        return fibList;
    }

    public static int findGreatestCommonDecimal(int arg1, int arg2) {
        if (arg1 == 0) {
            return arg2;
        }
        if (arg2 == 0) {
            return arg1;
        }
        if (arg1 == arg2) {
            return arg1;
        }
        if (arg1 > arg2) {
            return findGreatestCommonDecimal(arg1 - arg2, arg2);
        }
        return findGreatestCommonDecimal(arg1, arg2 - arg1);
    }

    public static void main(String[] args) {

        List<Integer> fibonacciSeries = findFibonacciList(45);

        for (int i = 40; i < 44; i++) {
            int j = i + 1;
            System.out.println("GCD of index " + i + " and index " + j + " : " + findGreatestCommonDecimal(fibonacciSeries.get(i), fibonacciSeries.get(j)));
        }

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution Time: " + executionTime + " milliseconds");
    }
}
