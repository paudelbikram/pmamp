package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.ListNode;
import com.grind75.common.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class MajorityElementSolution implements Solution {

    private int solve(int[] nums) {
        int majorityThreshold = nums.length / 2;
        Map<Integer, Integer> numberAndCounter = new HashMap<>();
        for (int n : nums) {
            if (numberAndCounter.containsKey(n)) {
                int counter = numberAndCounter.get(n);
                if (counter + 1 > majorityThreshold) {
                    return n;
                }
                numberAndCounter.put(n, counter + 1);
            } else {
                numberAndCounter.put(n, 1);
            }
        }
        return -1; //to indicate non-existing majority element
    }


    @Override
    public void run() {
        System.out.println("Running Majority Element Solution");
        int expectedSolution1 = 3;
        int actualSolution1 = this.solve(new int[]{3, 2, 3});
        Comparator.compare(actualSolution1, expectedSolution1);

        int expectedSolution2 = 2;
        int actualSolution2 = this.solve(new int[]{2, 2, 1, 1, 1, 2, 2});
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
