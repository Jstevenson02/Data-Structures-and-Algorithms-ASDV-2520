package practice.computefactorial;

import java.util.Scanner;

public class ComputeFactorial {

    /**
     * Main method
     */
    public static void main(String[] args) {
        System.out.print("Enter a non-negative integer: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        printSequenceOfNumber(n);
    }

    public static long factorialLoop(int n) {

        long fact = 1;

        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    /**
     *
     * @param n
     */
    public static void printSequenceOfNumber(int n) {

        if (n == 0) {
            return;
        }
        System.out.println(n + " ");
        printSequenceOfNumber(--n);
    }

    /**
     * Return the factorial for a specified number
     */
    public static void HelloNTimes(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Hello.");
                HelloNTimes(--n);

    }

    public static long factorial(int n) {
        if (n == 0) // Base case
        {
            return 1;
        } else {
            return n * factorial(n - 1); // Recursive call
        }
    }
}
