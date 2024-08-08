package com.grind75.week3;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 */
public class ZeroOneMatrixSolution implements Solution {

    public int[][] solve(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // Initialize the queue with cells containing 0 and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        // defines the directions to move in the matrix (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // Perform BFS from cells containing 0
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    result[newX][newY] = result[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return result;
    }

    @Override
    public void run() {
        System.out.println("Zero One Matrix Solution");
        int[][] test1input1 = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] expectedSolution1 = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] actualSolution1 = this.solve(test1input1);
        Comparator.compare2DIntArray(actualSolution1, expectedSolution1);

        int[][] test2input1 = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][] expectedSolution2 = new int[][]{{0,0,0},{0,1,0},{1,2,1}};
        int[][] actualSolution2 = this.solve(test2input1);
        Comparator.compare2DIntArray(actualSolution2, expectedSolution2);
    }


}
