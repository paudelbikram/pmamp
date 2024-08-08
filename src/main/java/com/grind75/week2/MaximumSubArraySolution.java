package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.ListNode;
import com.grind75.common.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-subarray
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
public class MaximumSubArraySolution implements Solution {

    private int solve(List<Integer> nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (Integer num : nums) {
            currentSum += num;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
    @Override
    public void run() {
        System.out.println("Maximum Sub Array Solution");
        List<Integer> testNum1 = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
        int expectedSolution1 = 6;
        int actualSolution1 = this.solve(testNum1);
        Comparator.compare(actualSolution1, expectedSolution1);

        List<Integer> testNum2 = List.of(1);
        int expectedSolution2 = 1;
        int actualSolution2 = this.solve(testNum2);
        Comparator.compare(actualSolution2, expectedSolution2);

        List<Integer> testNum3 = Arrays.asList(5,4,-1,7,8);
        int expectedSolution3 = 23;
        int actualSolution3 = this.solve(testNum3);
        Comparator.compare(actualSolution3, expectedSolution3);
    }


}
