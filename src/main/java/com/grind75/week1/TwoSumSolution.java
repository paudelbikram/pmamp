package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * TOPIC : ARRAY
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that
 * they add up to target. You may assume that each input would have exactly one solution, and you may
 * not use the same element twice. You can return the answer in any order.
 */
public class TwoSumSolution implements Solution {

    public int[] solveByCalculatingComplement(int[] nums, int target) {
        int[] resultArray = new int[2];
        Map<Integer, Integer> complementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (complementMap.containsKey(nums[i])) {
                resultArray[0] = complementMap.get(nums[i]);
                resultArray[1] = i;
                break;
            }
            complementMap.put(target - nums[i], i);
        }
        return resultArray;
    }

    @Override
    public void run() {
        System.out.println("Running TwoSum Solution");

        int[] firstResultExpected = new int[]{0, 1};
        int[] firstResult = this.solveByCalculatingComplement(new int[]{2, 7, 11, 15}, 9);
        Comparator.compareIntArray(firstResult, firstResultExpected);

        int[] secondResultExpected = new int[]{1, 2};
        int[] secondResult = this.solveByCalculatingComplement(new int[]{3, 2, 4}, 6);
        Comparator.compareIntArray(secondResult, secondResultExpected);

        int[] thirdResultExpected = new int[]{0, 1};
        int[] thirdResult = this.solveByCalculatingComplement(new int[]{3, 3}, 6);
        Comparator.compareIntArray(thirdResult, thirdResultExpected);

    }
}
