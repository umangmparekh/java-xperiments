package org.example;

import java.util.Arrays;

/**
 *     Problem : Given two strings, write a method to decide if one is a permutation of the other.
 *     Solution: Sort Both Strings
 *
 */
public class CheckPermutationV1 {

    public static void main(String arg[]){

        String str1 = "Umang";
        String str2 = "manUg";
        System.out.println("Version 1 : Sorting");
        System.out.println("Check string permutation for String 1 :"+str1+" & String 2 :"+str2);
        System.out.println("Result : "+CheckPermutation(str1, str2));

        System.out.println("Version 2 : Count Characters");
        System.out.println("Check string permutation for String 1 :"+str1+" & String 2 :"+str2);
        System.out.println("Result : "+CheckPermutationNext(str1, str2));
    }

    public static boolean CheckPermutationNext(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        int[] letters = new int[128]; // ASCII

        for(int i=0;i<str1.length();i++){
            letters[str1.charAt(i)]++;
        }

        for(int j=0;j<str2.length();j++){
            letters[str2.charAt(j)]--;
            if(letters[str2.charAt(j)]<0)
                    return false;
        }

        return true;
    }
    public static boolean CheckPermutation(String str1, String str2) {

        if(str1.length() != str2.length())
            return false;

        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);

    }
}
