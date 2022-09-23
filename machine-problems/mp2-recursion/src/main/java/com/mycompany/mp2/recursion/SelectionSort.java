 package com.mycompany.mp2.recursion;

/**
 *
 * @author jacob
 */
class SelectionSort {


        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    public static void selectionSort(int[] arr, int i, int n)
    {
        int min = i;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] < arr[min]) {
                min = j;    
            }
        }
 
        swap(arr, min, i);
 
        if (i + 1 < n) {
            selectionSort(arr, i + 1, n);
        }
    }
 
    public static void main(String args[]) {
        int arr[] = {8, 2, 1, 1, 7, 4, -1, 50, 49};

        selectionSortR(arr, arr.length, 0);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
