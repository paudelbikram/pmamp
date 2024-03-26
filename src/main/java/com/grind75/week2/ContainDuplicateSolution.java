package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/contains-duplicate
 * Given an integer array nums, return true if any value
 * appears at least twice in the array, and return false
 * if every element is distinct.
 */
public class ContainDuplicateSolution implements Solution {

    private boolean solve(int[] numbers) {
        HashMap<Integer, Boolean> dupMap = new HashMap<>();
        for (int num : numbers) {
            if (dupMap.containsKey(num)) {
                return true;
            }
            dupMap.put(num, true);
        }
        return false;
    }
    @Override
    public void run() {
        System.out.println("Contain Duplicate Solution");
        int[] test1 = new int[]{1,2,3,1};
        boolean expectedSolution1 = true;
        boolean actualSolution1 = this.solve(test1);
        Comparator.compare(actualSolution1, expectedSolution1);

        int[] test2 = new int[]{1,2,3,4};
        boolean expectedSolution2 = false;
        boolean actualSolution2 = this.solve(test2);
        Comparator.compare(actualSolution2, expectedSolution2);

        int[] test3 = new int[]{1,1,1,3,3,4,3,2,4,2};
        boolean expectedSolution3 = true;
        boolean actualSolution3 = this.solve(test3);
        Comparator.compare(actualSolution3, expectedSolution3);

    }
}
