package org.example;

/**
 *
 * Write a method to replace all spaces in a string with %20.
 * You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
 *
 *Time Complexity
 * O(n) — where n is the true length of the string
 *
 * We scan the string once to count spaces (O(n)) and once more to replace spaces from the end (O(n))
 * Combined: O(n) + O(n) → O(n)
 *
 * Space Complexity
 * O(1) — we modify the array in place without using extra space proportional to n
 * Just a few integer variables for counters
 */
public class URLify {

    public static void main(String arg[]){

        String input = "Mr Umang Parekh    ";
        int inputLength = 15;
        char[] charArray = input.toCharArray();
        replaceSpaces(charArray, inputLength);

        System.out.println("\"" + new String(charArray) + "\"");
    }


    public static void replaceSpaces(char[] str, int inputLength) {
        int spaceCount = 0;
        for (int i = 0; i < inputLength; i++) {
            if(str[i]==' ') spaceCount++;
        }
        System.out.println(" Space count char '"+spaceCount+"'");

        int index = inputLength + spaceCount * 2;
        // If there’s extra space at the end
        if (inputLength < str.length) str[inputLength] = '\0';
        System.out.println("\"" + new String(str) + "\"");

        // Replace spaces from end
        for (int i = inputLength - 1; i >= 0; i--) {
            System.out.println(" Operating char '"+str[i]+"'");
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
