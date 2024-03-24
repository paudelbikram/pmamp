package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-search/
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearchSolution implements Solution {

    private int solve(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1; //unsigned right shift operator
            int midVal = nums[mid];
            if (target > midVal)
                low = mid + 1;
            else if (target < midVal)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -1;
    }

    private int solveUsingCollectionsBinarySearch(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        int result = Collections.binarySearch(list, target);
        if (result < 0) {
            return -1;
        } else {
            return result;
        }
    }

    @Override
    public void run() {
        System.out.println("Running Binary Search Solution");
        int expectedSolution = 4;
        int actualSolution = this.solveUsingCollectionsBinarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        Comparator.compare(actualSolution, expectedSolution);

        int expectedSolution1 = -1;
        int actualSolution1 = this.solveUsingCollectionsBinarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        Comparator.compare(actualSolution1, expectedSolution1);

        //test solve vs solveUsingCollectionsBinarySearch
        Comparator.compare(this.solveUsingCollectionsBinarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 2),
                this.solve(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        Comparator.compare(this.solveUsingCollectionsBinarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9),
                this.solve(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        Comparator.compare(this.solveUsingCollectionsBinarySearch(new int[]{-1, 0, 3, 5, 9, 12, 18}, 0),
                this.solve(new int[]{-1, 0, 3, 5, 9, 12, 18}, 0));
        Comparator.compare(this.solveUsingCollectionsBinarySearch(new int[]{-1, 0, 3, 5, 9, 12, 18}, 20),
                this.solve(new int[]{-1, 0, 3, 5, 9, 12, 18}, 20));
    }
}
