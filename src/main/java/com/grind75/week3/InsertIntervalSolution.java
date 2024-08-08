package com.grind75.week3;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * https://leetcode.com/problems/insert-interval
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another
 * interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 */
public class InsertIntervalSolution implements Solution {

    private int[][] solve(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        // Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        // Merge intervals that overlap with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add all remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[0][]);
    }


    @Override
    public void run() {
        System.out.println("Insert Interval Solution");
        int[][] test1input1 = new int[][]{{1,3},{6,9}};
        int[] test1input2 = new int[]{2,5};
        int[][] expectedSolution1 = new int[][]{{1,5},{6,9}};
        int[][] actualSolution1 = this.solve(test1input1, test1input2);
        Comparator.compare2DIntArray(actualSolution1, expectedSolution1);

        int[][] test2input1 = new int[][]{{1,2},{3,5}, {6,7}, {8,10}, {12,16}};
        int[] test2input2 = new int[]{4,8};
        int[][] expectedSolution2 = new int[][]{{1,2},{3,10}, {12,16}};
        int[][] actualSolution2 = this.solve(test2input1, test2input2);
        Comparator.compare2DIntArray(actualSolution2, expectedSolution2);
    }
}
