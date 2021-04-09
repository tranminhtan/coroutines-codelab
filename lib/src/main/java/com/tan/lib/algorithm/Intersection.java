package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Intersection {
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 5, 3, 2};
        int[] arr2 = {6, 3, 8, 5, 3, 2};
        PrintUtils.print(intersection(arr1, arr2));
        PrintUtils.print(intersectionSortedArray(arr1, arr2));
    }

    /**
     * Find intersection of 2 unsorted arrays
     * <p>
     * Init a Set, put one array into the set
     * Init an array to keep the common - unique elements
     * Walk thru the 2nd array
     * check if it exists
     * add it into result array
     * remove it from set to maintain unique elements in result
     */
    private static int[] intersection(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            throw new IllegalStateException();
        }
        Set<Integer> set = new HashSet<>();
        for(int a : arr1) {
            set.add(a);
        }
        List<Integer> tempt = new ArrayList<>();
        for (int b: arr2) {
            if (set.contains(b)) {
                tempt.add(b);
                set.remove(b);
            }
        }

        int i = 0;
        int[] result = new int[tempt.size()];
        for(int t : tempt) {
            result[i++] = t;
        }
        return result;
    }

    private static int[] intersectionSortedArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Set<Integer> tempt = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                tempt.add(arr1[i]);
                i++;
                j++;
            }
        }
        i = 0;
        int[] result = new int[tempt.size()];
        for(int t : tempt) {
            result[i++] = t;
        }
        return result;
    }
}
