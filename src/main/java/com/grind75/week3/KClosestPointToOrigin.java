package com.grind75.week3;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane
 * and an integer k, return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2). You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosestPointToOrigin implements Solution {

    public int[][] solve(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        for (int[] point : points) {
            pq.offer(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    @Override
    public void run() {
        System.out.println("K Closest Point To Origin Solution");
        int[][] test1input1 = new int[][]{{1,3},{-2,2}};
        int k1 = 1;
        int[][] expectedSolution1 = new int[][]{{-2,2}};
        int[][] actualSolution1 = this.solve(test1input1, k1);
        Comparator.compare2DIntArray(actualSolution1, expectedSolution1);

        int[][] test2input1 = new int[][]{{3,3},{5,-1},{-2,4}};
        int k2 = 2;
        int[][] expectedSolution2 = new int[][]{{3,3},{-2,4}};
        int[][] actualSolution2 = this.solve(test2input1, k2);
        Comparator.compare2DIntArray(actualSolution2, expectedSolution2);
    }


}
