package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int x = 4;
        int index = new BinarySearch().search(arr, x);
        PrintUtils.print(index);
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
        while (l <= r) {
            int mid = l + (r - l) / 2;
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
}
