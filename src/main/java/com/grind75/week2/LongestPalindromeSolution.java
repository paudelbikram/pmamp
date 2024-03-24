package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * TOPIC : STRING
 * https://leetcode.com/problems/longest-palindrome/
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with
 * those letters. Letters are case-sensitive, for example, "Aa" is not
 * considered a palindrome here.
 */
public class LongestPalindromeSolution implements Solution {

    public int solve(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] characters = s.toCharArray();
        int exactPairCount = 0;
        Set<Character> characterSet = new HashSet<>();
        for (char c : characters) {
            if (characterSet.contains(c)) {
                characterSet.remove(c);
                exactPairCount++;
            } else {
                characterSet.add(c);
            }
        }
        return (exactPairCount * 2) + (characterSet.size() > 0 ? 1 : 0);
    }

    @Override
    public void run() {
        System.out.println("Running Longest Palindrome Solution");
        int expectedSolution1 = 7;
        int actualSolution1 = this.solve("abccccdd");
        Comparator.compare(actualSolution1, expectedSolution1);

        int expectedSolution2 = 1;
        int actualSolution2 = this.solve("a");
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
