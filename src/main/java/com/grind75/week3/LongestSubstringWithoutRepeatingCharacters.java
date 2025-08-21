package com.grind75.week3;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Given a string s, find the length of the longest substring without duplicate characters.
 */
public class LongestSubstringWithoutRepeatingCharacters implements Solution {

    public int solve(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                max = Math.max(map.size(), max);
                map.clear();
                map.put(c, i);
            } else {
                map.put(c, i);
            }
        }
        return max;
    }

    @Override
    public void run() {
        System.out.println("Longest Substring Without Repeating Characters Solution");
        String test1input1 = "abcabcbb";
        int expectedSolution1 = 3;
        int actualSolution1 = this.solve(test1input1);
        Comparator.compare(actualSolution1, expectedSolution1);

        String test1input2 = "bbbbb";
        int expectedSolution2 = 1;
        int actualSolution2 = this.solve(test1input2);
        Comparator.compare(actualSolution2, expectedSolution2);

        String test1input3 = "pwwkew";
        int expectedSolution3 = 3;
        int actualSolution3 = this.solve(test1input3);
        Comparator.compare(actualSolution3, expectedSolution3);
    }

}
