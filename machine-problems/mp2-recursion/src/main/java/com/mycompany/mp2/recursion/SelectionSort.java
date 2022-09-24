package com.mycompany.mp2.recursion;

/**
 *
 * @author jacob
 */
class SelectionSort {

    static void selectionSortOneRecursiveFunction(int a[], int index, int n) {

        // Find Min Index
        int min = index;
        for (int j = index + 1; j < n; j++) {
            if (a[j] < a[min]) {
                min = j;
            }
        }

        // Swap with Next Element
        int temp = a[min];
        a[min] = a[index];
        a[index] = temp;

        // Check If we have more work to do
        if (index + 1 < n) {
            selectionSortOneRecursiveFunction(a, index + 1, n);
        }
    }

    public static void main(String args[]) {
        int arr[] = {8, 2, 1, 1, 7, 4, -1, 50, 49};

        selectionSortOneRecursiveFunction(arr, 0, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
