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

    static void selectionSortR(int a[], int n, int index) {

        if (index == n) {
            return;
        }

        int k = minIndex(a, index, n - 1);

        if (k != index) {
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        selectionSortR(a, n, index + 1);
    }

    public static void main(String args[]) {
        int arr[] = {10, 1, 20, 3};

        selectionSortR(arr, arr.length, 0);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
