package org.example;

/**
 *
 * Problem Statement
 * Check if one string is a rotation of another using only one call to isSubstring.
 *
 * Input:
 * s1 = "waterbottle"
 * s2 = "erbottlewat"
 *
 * Output:
 * true   // because "erbottlewat" is a rotation of "waterbottle"
 *
 * Idea :
 * Key Insight
 * If s2 is a rotation of s1, then it will always be a substring of s1 + s1.
 *
 * s1 = waterbottle
 * s1 + s1 = waterbottlewaterbottle
 *
 * s2 = erbottlewat
 * "erbottlewat" is inside "waterbottlewaterbottle"
 *
 * Time & Space Complexity
 * Time Complexity:
 * O(N) — where N is the string length; contains typically uses KMP or similar search.
 * Space Complexity:
 * O(N) — for storing s1 + s1.
 *
 *
 */
public class StringRotation {
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }
        String s1s1 = s1 + s1;
        return s1s1.contains(s2); // single call to isSubstring
    }
    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat")); // true
        System.out.println(isRotation("hello", "llohe")); // true
        System.out.println(isRotation("hello", "ohellx")); // false
    }

}
