package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 3, 0, 5, 0};
        new MoveZeros().moveZerosPartition(arr);
        PrintUtils.print(arr);
    }

    /**
     * Move zeros to the end of array
     * <p>
     * 1. A pointer keep track of non-zero index
     * 2. Iterate from the start
     * 3. If curr element not zero, update it at pointer index
     * 4. Increase pointer
     * 5. Loop from pointer to end, update remaining elements with 0
     */
    private void moveZeros(int[] arr) {
        // {0, 3, 0, 2, 0, 5, 2}
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k++] = arr[i];
            }
        }

        for (int i = k; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    /**
     * 1. A pointer of the last non-zero element
     * 2. Iterate from the start
     * 3. If curr element is not 0, swap it with the pointer element
     */
    private void moveZerosPartition(int[] arr) {
        for (int k = 0, i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int t = arr[i];
                arr[i] = arr[k];
                arr[k] = t;
                k++;
            }
        }
    }
}
