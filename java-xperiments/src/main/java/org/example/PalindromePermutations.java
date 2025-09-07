package org.example;

/**
 *
 * Given a string, write a function to check if it is a permutation of a palindrome.
 *
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome doesn’t need to be limited to just dictionary words.
 *
 * For a string to be a permutation of a palindrome:
 * Each character must appear an even number of times,
 * Except for at most one character, which can appear an odd number of times (middle character in odd-length palindrome).
 *
 *💡 Steps:
 * Ignore spaces and make characters lowercase.
 * Count occurrences of each character.
 * Check that at most one character has an odd count.
 *
 *
 * Code Recap:
 * We use an int[] table of fixed size (128 for ASCII)
 * Loop once to count characters (O(n))
 * Loop again to check counts (O(1) since table size is constant)
 *
 * Time Complexity:
 * O(n) → We scan the string once (n = number of characters in input)
 *
 * Space Complexity:
 * O(1) → The int[] table has constant size (128), so memory usage does not grow with n
 *
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class PalindromePermutations {

    public  static boolean isPalindromePermutation(String str){
        int[] table = new int[128]; // ASCII table size
        str = str.toLowerCase();

        for (char c : str.toCharArray()) {
            if (c != ' ') {
                table[c]++;
            }
        }

        boolean foundOdd = false;
        for (int count : table) {
            System.out.println("Count >> "+count);
            if (count % 2 != 0) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa")); // true ("taco cat", "atco cta")
        System.out.println(isPalindromePermutation("Hellooe"));    // false
    }
}
