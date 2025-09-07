package org.example;

/**
 *
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * Example:
 * "aabcccccaaa" → "a2b1c5a3"
 * If the compressed string would not be smaller than the original, return the original string.
 *
 *
 *
 * Time Complexity
 * O(n) — We scan the string once
 * Building the new string is proportional to n
 * Space Complexity
 * O(n) — StringBuilder stores up to twice the original string length in worst case
 */
public class StringCompression {

    public static String CompressedString(String str){

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next char is different or end of string, append this char and count
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        // Return the shorter one
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
    public static void main(String[] args) {
        String str1 = "pale";
        System.out.println(CompressedString(str1));
        String str2 = "aabcccccaaa";
        System.out.println(CompressedString(str2));

    }

}
