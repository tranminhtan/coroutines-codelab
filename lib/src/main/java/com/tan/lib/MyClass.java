package com.tan.lib;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("Test");
    }

    public int reverse(int x) {
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        String reversedX;
        if (x > 0) {
            reversedX = builder.reverse()
                    .toString();
        } else {
            reversedX = builder.deleteCharAt(0)
                    .reverse()
                    .insert(0, "-")
                    .toString();
        }
        try {
            return Integer.parseInt(reversedX);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}