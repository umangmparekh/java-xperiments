package org.example;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * Time Complexity:
 * O(n2) — where n is the length of the string
 * Space: O(1) for the set
 */
public class ArrayIsUnique {

    public static void main(String arg[]){

        String checkUniqueString = "isUniqueStringOrNot";
        System.out.println("String  "+checkUniqueString+" | is unique :>>> "+isUnique(checkUniqueString));
    }

    public static boolean isUnique(String checkStr){

        int length = checkStr.length();

        for(int i=0; i<length; i++){
            for(int j=i+1; j<length; j++){
                if(checkStr.charAt(i)==checkStr.charAt(j)){
                    return false;
                }
            }
        }

        return true;
    }

}
