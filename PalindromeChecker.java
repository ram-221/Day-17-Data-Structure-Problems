package com.bridgelabz;
import java.util.ArrayDeque;
import java.util.Scanner;


public class PalindromeChecker {

	public static void checkPalindrome(String str) {

        String reverseString = "";

        ArrayDeque<Character> arrayDeque = new ArrayDeque<Character>();

        for (int i = str.length() - 1; i >= 0; i--) {
            /*
             add method to add elements one by one  using charAt position
             */
            arrayDeque.add(str.charAt(i));
        }

       
        while (!arrayDeque.isEmpty()) {
            reverseString = reverseString + arrayDeque.remove();
        }
        /*
        if reverse String is equals to the enter string then it is palindrome
         */
        if (str.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a String to check for palindrome or not");

        String str = scanner.next();

        str = str.toLowerCase();
        checkPalindrome(str);

    }
}
