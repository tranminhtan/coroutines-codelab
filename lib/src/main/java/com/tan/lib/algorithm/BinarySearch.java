package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

class BinarySearch {
    public static void main(String[] args) {
        int max = 1_000_000_000;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = i;
        }
        int x = max;
        BinarySearch binarySearch = new BinarySearch();

        long start = System.nanoTime();
        int index = binarySearch.binarySearchOptimised(arr, x);
        long end = System.nanoTime();

        long start1 = System.nanoTime();
        int index1 = binarySearch.search(arr, x);
        long end1 = System.nanoTime();

        long optimised = end - start;
        long normal = end1 - start1;

        PrintUtils.print(index);
        PrintUtils.print(index1);
        PrintUtils.print(normal - optimised);
    }

    /**
     * pre-condition: sorted array
     * define l, r
     * while(l <= r)
     * calculate mid and compare it with x
     * 1. == x return
     * 2. > x, x will be on the left (if found), update r
     * 3. < x, x will be on the right (if found), update l
     * return -1 if not found
     */
    int search(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (x == arr[mid]) {
                return mid;
            } else if (x > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchOptimised(int[] arr, int x) {
        int l = 0;
        int h = arr.length - 1;
        int m;
        while (l <= h) {
            m = l + (h - l >>> 1);

            if (arr[m] < x) {
                l = m + 1;
            } else {
                if (arr[m] == x) {
                    return m;
                }
                h = m - 1;
            }
        }
        return -1;
    }
}
