package com.grind75.week3;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/description/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum implements Solution {

    public List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }


    @Override
    public void run() {
        System.out.println("Three Sum Solution");
        int[] testInput1 = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> expectedSolution1 = Arrays.asList(List.of(-1,-1,2), List.of(-1,0,1));
        List<List<Integer>> actualSolution1 = this.solve(testInput1);
        Comparator.compareListOfList(actualSolution1, expectedSolution1);

        int[] testInput2 = new int[]{0,1,1};
        List<List<Integer>> expectedSolution2 = List.of();
        List<List<Integer>> actualSolution2 = this.solve(testInput2);
        Comparator.compareListOfList(actualSolution2, expectedSolution2);

        int[] testInput3 = new int[]{0,0,0};
        List<List<Integer>> expectedSolution3 = List.of(Arrays.asList(0, 0, 0));
        List<List<Integer>> actualSolution3 = this.solve(testInput3);
        Comparator.compareListOfList(actualSolution3, expectedSolution3);
    }

}
