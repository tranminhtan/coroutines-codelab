package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class StringAnagram {
    public static void main(String[] args) {
        PrintUtils.print(isAnagram("abcd", "dcba"));
        PrintUtils.print(isAnagramCount("abcd", "dcba"));

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        PrintUtils.print(groupAnagram(input));
    }

    /**
     * NOTE: CHECK THE INPUT CONSTRAINTS: upper case, lower case, range
     * 1st
     * Fail fast by checking their length
     * Sort both -> nlog(n)
     * Compare -> n
     * <p>
     * 2nd
     * Fail fast by checking their length
     * <p>
     * Compare 2 sets
     * <p>
     * eg: "abcd", "aabb"
     */
    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * CONSTRAINT: string contains lower-case english alphabet -> 26 chars
     * <p>
     * fail fast -> compare length
     * init a count array size 26
     * walk thru both arrays
     * increase the appearance of the chars in 1srt
     * decrease the appearance of the chars in 2nd
     * walk thru count array
     * if any element != 0
     * return false
     * return true
     */
    private static boolean isAnagramCount(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        if (n1 != n2) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < n1; i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        for (int v : count) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    // {1, 1, 2, 1, 2,3 }
    // {{1, 1, 1}, {2,2}, {3}}

    /**
     * walk thru the array i: 0 -> n-2
     * if(visited)
     * continues
     * create a new list, put curr into the list
     * walk thru the array i+1 -> n-1
     * if they're anagram & not visited
     * put curr into list
     * mart it as visited
     */
    // {"eat", "tea", "tan", "ate", "nat", "bat"};
    // [[eat, tea, ate], [tan, nat], [bat]]
    private static List<List<String>> groupAnagram(String[] input) {
        if (input == null || input.length == 0) {
            return Collections.emptyList();
        }
        List<List<String>> result = new ArrayList<>();
        Set<String> grouped = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            if (!grouped.contains(input[i])) {
                grouped.add(input[i]);
                List<String> list = new ArrayList<>();
                list.add(input[i]);
                for (int j = i + 1; j < input.length; j++) {
                    if (!grouped.contains(input[j]) && isAnagram(input[i], input[j])) {
                        grouped.add(input[j]);
                        list.add(input[j]);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

     String test() {
        String s = "fdfd";
        char[] c = s.toCharArray();
        for (int i = 1; i < c.length - 1; i += 2) {
            c[i] = '$';
        }
        return String.valueOf(c);
    }

}
