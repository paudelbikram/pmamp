package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/ransom-note/
 * Given two strings ransomNote and magazine, return true if
 * ransomNote can be constructed by using the letters from magazine
 * and false otherwise. Each letter in magazine can only be used once
 * in ransomNote.
 */
public class RansomNoteSolution implements Solution {

    private boolean solve(String ransomNote, String magazine) {
        char[] magazineArray = magazine.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : magazineArray) {
            if (hashMap.containsKey(c)) {
                Integer counter = hashMap.get(c);
                hashMap.put(c, counter + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        char[] ransomArray = ransomNote.toCharArray();
        for (char c : ransomArray) {
            if (hashMap.containsKey(c)) {
                int counter = hashMap.get(c);
                if (counter == 1) {
                    hashMap.remove(c);
                } else {
                    hashMap.put(c, counter - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println("Running Ransom Note Solution");
        boolean expectedSolution1 = false;
        boolean actualSolution1 = this.solve("a", "b");
        Comparator.compare(actualSolution1, expectedSolution1);

        boolean expectedSolution2 = false;
        boolean actualSolution2 = this.solve("aa", "ab");
        Comparator.compare(actualSolution2, expectedSolution2);

        boolean expectedSolution3 = true;
        boolean actualSolution3 = this.solve("aa", "aab");
        Comparator.compare(actualSolution3, expectedSolution3);
    }
}
