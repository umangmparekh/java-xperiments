package org.example;

/**
 *
 * Write a function to check if two strings are one edit (or zero edits) away from each other.
 * An edit is:
 * Insert a character
 * Remove a character
 * Replace a character
 *
 *
 * If lengths differ by more than 1 → false.
 * If lengths are equal → check for at most one replacement.
 * If lengths differ by 1 → check for at most one insertion/removal.
 *
 * ⏳ Time Complexity:
 * O(n) where n is the length of the shorter string
 * We scan both strings at most once
 * 💾 Space Complexity:
 * O(1) — only a few extra variables
 */
public class OneAway_CTCI {

    public static boolean isOneAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        // Same length → check replacement
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        }

        // Length differs → check insert/remove
        else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }

        return false;

    }

    private static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return true;
    }

    private static boolean oneEditInsert(String shorter, String longer) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < shorter.length() && index2 < longer.length()) {
            if (shorter.charAt(index1) != longer.charAt(index2)) {

                if (index1 != index2) return false;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "ple";

        System.out.println(isOneAway(str1, str2));
    }
}
