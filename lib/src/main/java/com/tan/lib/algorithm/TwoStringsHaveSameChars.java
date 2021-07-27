package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

class TwoStringsHaveSameChars {
    public static void main(String[] args) {
        PrintUtils.print(twoStringHaveSameChars("Geeks", "Geks"));
        PrintUtils.print(twoStringHaveSameChars("Geeks", "Geksss"));
        PrintUtils.print(twoStringHaveSameChars("Geeks", "Geksss"));
    }

    /**
     * Input:   Geeks, Geks
     * Output:  true
     * <p>
     * Remove duplicate neighbor chars s1 & s2
     * Init a String builder
     * pointer = first char
     * walk thru the strings
     * if pointer !=  curr
     * put curr into builder
     * update pointer
     * Then compare them
     */
    private static boolean twoStringHaveSameChars(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }
        return getCleanString(s1).equals(getCleanString(s2));
    }

    private static String getCleanString(String str) {
        char s = str.charAt(0);
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        for (int i = 1; i < str.length(); i++) {
            if (s != str.charAt(i)) {
                builder.append(str.charAt(i));
                s = str.charAt(i);
            }
        }
        PrintUtils.print(builder.toString());
        return builder.toString();
    }
}
