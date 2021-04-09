package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

class Palindrome {
    public static void main(String[] args) {
        PrintUtils.print(isPalindrome("abcdcba"));
        PrintUtils.print(isPalindrome("1234321"));
        PrintUtils.print(isPalindrome("12343321"));

        PrintUtils.print(isPalindromeLine("abcdcba"));
        PrintUtils.print(isPalindromeLine("1234321"));
        PrintUtils.print(isPalindromeLine("12343321"));
    }

    static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse()
                .toString());
    }

    static boolean isPalindromeLine(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0, j = str.length() - 1; i < j; i++, j--){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
