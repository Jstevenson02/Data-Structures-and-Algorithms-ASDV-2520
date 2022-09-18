/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.javatest;

/**
 *
 * @author jacob
 */
class SelectionSort {

    static int minIndex(int a[], int i, int j) {
        if (i == j) {
            return i;
        }

        int k = minIndex(a, i + 1, j);

        return (a[i] < a[k]) ? i : k;
    }

    // Recursive selection sort. n is size of a[] and index
    // is index of starting element.
    static void selectionSortR(int a[], int n, int index) {

        // Return when starting and size are same
        if (index == n) {
            return;
        }

        // calling minimum index function for minimum index
        int k = minIndex(a, index, n - 1);

        // Swapping when index nd minimum index are not same
        if (k != index) {
            // swap
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        // Recursively calling selection sort function
        selectionSortR(a, n, index + 1);
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {8, 2, 1, 1, 7, 4, -1, 50, 49};

        // Calling function
        selectionSortR(arr, arr.length, 0);

        //printing sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
