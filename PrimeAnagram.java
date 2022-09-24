package com.bridgelabz;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CheckAnagram {
	
	 static void updateFreq(int n, int[] freq) {

	        while (n > 0) {
	            int digit = n % 10;
	            // Update the frequency of the current digit
	            freq[digit]++;
	            // Remove the last digit
	            n /= 10;
	        }
	    }
	    /*
	     Function that returns true if a and b are anagarams of each other
	     */
	    static boolean areAnagrams(int a, int b) {
	        // To store the frequencies of the digits in a and b
	        int[] freqA = new int[10];
	        int[] freqB = new int[10];
	       
	        updateFreq(a, freqA);
 
	        updateFreq(b, freqB);

	        // Match the frequencies of the common digits
	        for (int i = 0; i < 10; i++) {
	           
	            if (freqA[i] != freqB[i])
	                return false;
	        }
	        return true;
	    }
}


public class PrimeAnagram {

	 public static List<Integer> filterAnagram(List<Integer> list) {
	        List<Integer> anagramlist = new ArrayList<>();

	        for (int i = 0; i < list.size(); i++) {

	            for (int j = i + 1; j < list.size(); j++) {
	/*
	Calling the function areAnagrams from CheckAnagram class and it will add in the anagramlist
	 by giving values of prime numbers in the list one by one using addlist(i) and addlist(j)
	 */
	                boolean isAnagram = CheckAnagram.areAnagrams(list.get(i), list.get(j));
	                if (isAnagram) {
	                    anagramlist.add(list.get(i));
	                    anagramlist.add(list.get(j));
	                }

	            }
	        }
	        return anagramlist;
	    }

	    public static void main(String[] args) {
	        int start = 0;
	        int end = 100;
	  
	        int result[][] = new int[10][];

	        for (int i = 0; i < 10; i++) {
	            /*
	            list is taken rather than array because we don't know how many prime numbers are there
	             */
	            List<Integer> list = new ArrayList<>();

	            for (int j = start; j <= end; j++) {
	                boolean isPrime = true;
	        /*
	        checking the number is prime or not if it is prime adding it in the list
	        */
	                for (int p = 2; p < j; p++) {
	                    if (j % p == 0) {
	                        isPrime = false;
	                    }
	                }

	                if (isPrime) {
	                    list.add(j);
	                }
	            }
	            /*
	            taking an integer list in filter Anagram numbers is
	             */
	            List<Integer> anagramlist = filterAnagram(list);

	       
	            int temp[] = new int[anagramlist.size()];
	            for (int z = 0; z < anagramlist.size(); z++) {
	                temp[z] = anagramlist.get(z);
	            }

	       
	            result[i] = temp;
	            start = start + 100;
	            end = end + 100;

	        }
	        for (int i = 0; i < result.length; i++) {
	            System.out.println("==================");
	            for (int j = 0; j < result[i].length; j++) {

	                System.out.println(result[i][j]);


	            }

	        }

	    }
}
