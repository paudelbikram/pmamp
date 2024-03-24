package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/valid-anagram/
 * Given two strings s and t, return true if t is an anagram of s,
 * and false otherwise. An Anagram is a word or phrase formed by
 * rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagramSolution implements Solution {

    private boolean solve(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] tChars = t.toCharArray();
        HashMap<Character, Integer> map = createMap(s);
        for (char aChar : tChars) {
            if (map.containsKey(aChar)) {
                int currentCounter = map.get(aChar);
                if (currentCounter == 0) {
                    map.remove(aChar);
                } else {
                    currentCounter--;
                    map.put(aChar, currentCounter);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> createMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        for (char aChar : sChars) {
            if (map.containsKey(aChar)) {
                int currentCount = map.get(aChar);
                currentCount++;
                map.put(aChar, currentCount);
            } else {
                map.put(aChar, 1);
            }
        }
        return map;
    }

    @Override
    public void run() {
        System.out.println("Running Valid Anagram Solution");

        boolean expectedSolution1 = true;
        boolean actualSolution1 = this.solve("anagram", "nagaram");
        Comparator.compare(actualSolution1, expectedSolution1);

        boolean expectedSolution2 = false;
        boolean actualSolution2 = this.solve("rat", "car");
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
