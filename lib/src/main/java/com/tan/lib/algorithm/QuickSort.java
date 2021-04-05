package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 3, 5, 8, 4};
        new QuickSort().quickSort(arr, 0, 6);
        PrintUtils.print(arr);
    }

    /**
     * pick a pivot (last element)
     * divide the array into 2 parts {elements < pivot}, pivot, {elements > pivot}
     * continue with the breakdown arrays
     */
    void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pi = partition(arr, l, h); // pivot index

            quickSort(arr, l, pi - 1);   // elements < pivot
            quickSort(arr, pi + 1, h);   // elements > pivot
        }
    }

    /**
     * pick pi = last index
     * keep a pointer of last element <= pivot
     * iterate array from l to h
     * if current <= pivot, swap it with the pointer element (update pointer index)
     */
    // {4, 2, 7, 3, 5, 8, 4} , 0, 6
    private int partition(int[] arr, int l, int h) {
        int pivot = arr[h]; // 4
        int k = l;
        // {4, 2, 3, 7, 5, 8, 4}
        // k = 0, 1, 2, 3
        // i = 0, 1, 2, 3, 4, 5, 6
        for (int i = l; i <= h; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, k);
                k++;
            }
        }
        return --k;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
