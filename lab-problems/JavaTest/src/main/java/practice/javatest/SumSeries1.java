/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.javatest;

/**
 *
 * @author jacob
 */
public class SumSeries1 {

    public static void main(String[] args) {
        System.out.printf("%-10s%-15s\n", "i", "m(i)");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-10d%-15.6f\n", i, m(i));
        }
    }

    public static double m(int i) {
        if (i == 1) {
            return 1;
        } else {
            return m(i - 1) + 1.0 / i;
        }
    }
}
