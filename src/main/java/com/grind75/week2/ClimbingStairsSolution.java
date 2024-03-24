package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct
 * ways can you climb to the top?
 */
public class ClimbingStairsSolution implements Solution {

    public int solve(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);
        for (int i = 3; i <= n; i++) {
            memo.put(i, memo.get(i - 1) + memo.get(i - 2));
        }
        return memo.get(n);
    }

    @Override
    public void run() {
        System.out.println("Running Climbing Stairs Solution");
        int expectedSolution1 = 2;
        int actualSolution1 = this.solve(2);
        Comparator.compare(actualSolution1, expectedSolution1);

        int expectedSolution2 = 3;
        int actualSolution2 = this.solve(3);
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
