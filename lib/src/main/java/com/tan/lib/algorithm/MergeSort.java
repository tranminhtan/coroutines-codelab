package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 3, 5, 7, 2};
        new MergeSort().mergeSort(arr, 0, arr.length - 1);
        PrintUtils.print(arr);
    }

    /**
     * Divide and conquer if(l < r)
     * 1. find mid
     * 2. mergesort(l to m)
     * 3. mergeSort(m+1, r)
     * 4. merge(l, m, r)
     */
    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /**
     * 1. Init 2 arrays [l to m], [m+1 to r]
     * 2. Create a new array with h size
     * 3. Create 2 pointers of curr elements of 2 arrays
     * 4. Iterate while both of them are not empty
     * 5. Compare and get the smaller
     * 6. One of 2 arrays can contain elements, copy it into arr
     */
    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            arr2[j] = arr[m + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            arr[k++] = arr1[i++];
        }
        while (j < n2) {
            arr[k++] = arr1[j++];
        }
    }
}
