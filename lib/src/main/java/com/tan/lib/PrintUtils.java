package com.tan.lib;

import java.util.Arrays;

public interface PrintUtils {
    static void print(Object object) {
        System.out.println(object);
    }

    static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
