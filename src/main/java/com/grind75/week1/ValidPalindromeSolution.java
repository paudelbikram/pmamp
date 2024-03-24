package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * A phrase is a palindrome if, after converting all uppercase letters
 * into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include
 * letters and numbers. Given a string s, return true if it is a palindrome,
 * or false otherwise.
 */
public class ValidPalindromeSolution implements Solution {

    private boolean isAlphaNumeric(char character) {
        return (character >= '0' && character <= '9') ||
                (character >= 'a' && character <= 'z') ||
                (character >= 'A' && character <= 'Z');
    }

    private String cleanAndLowercase(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (isAlphaNumeric(aChar)) {
                sb.append(Character.toLowerCase(aChar));
            }
        }
        return sb.toString();
    }

    private boolean solve(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        char[] chars = this.cleanAndLowercase(s).toCharArray();
        int lengthOfString = chars.length;
        int halfWay = lengthOfString / 2;
        for (int i = 0; i < halfWay; i++) {
            char currentChar = chars[i];
            char palindromePair = chars[lengthOfString - (i + 1)];
            if (currentChar != palindromePair) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println("Running Valid Palindrome Solution");

        boolean expectedSolution1 = true;
        boolean actualSolution1 = this.solve("A man, a plan, a canal: Panama");
        Comparator.compare(actualSolution1, expectedSolution1);
        boolean expectedSolution2 = false;
        boolean actualSolution2 = this.solve("race a car");
        Comparator.compare(actualSolution2, expectedSolution2);
        boolean expectedSolution3 = true;
        boolean actualSolution3 = this.solve("");
        Comparator.compare(actualSolution3, expectedSolution3);
    }
}
