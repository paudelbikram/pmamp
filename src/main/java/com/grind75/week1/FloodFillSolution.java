package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

/**
 * https://leetcode.com/problems/flood-fill/
 * An image is represented by an m x n integer grid image where image[i][j]
 * represents the pixel value of the image. You are also given three integers
 * sr, sc, and color. You should perform a flood fill on the image starting
 * from the pixel image[sr][sc]. To perform a flood fill, consider the
 * starting pixel, plus any pixels connected 4-directionally to the starting
 * pixel of the same color as the starting pixel, plus any pixels connected
 * 4-directionally to those pixels (also with the same color), and so on.
 * Replace the color of all the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 */
public class FloodFillSolution implements Solution {

    private int[][] solve(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        if (initialColor == color) {
            return image;
        }
        this.fill(image, sr, sc, initialColor, color);
        return image;
    }

    private void fill(int[][] image, int r, int c, int initialColor, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length
                || image[r][c] != initialColor) {
            return;
        }
        image[r][c] = newColor;
        this.fill(image, r + 1, c, initialColor, newColor);
        this.fill(image, r - 1, c, initialColor, newColor);
        this.fill(image, r, c + 1, initialColor, newColor);
        this.fill(image, r, c - 1, initialColor, newColor);
    }

    @Override
    public void run() {
        System.out.println("Running Flood Fill Solution");
        int[][] expectedSolution1 = new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        int[][] actualSolution1 = this.solve(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}},
                1, 1, 2);
        Comparator.compare2DIntArray(actualSolution1, expectedSolution1);

        int[][] expectedSolution2 = new int[][]{{0, 0, 0}, {0, 0, 0}};
        int[][] actualSolution2 = this.solve(new int[][]{{0, 0, 0}, {0, 0, 0}},
                0, 0, 0);
        Comparator.compare2DIntArray(actualSolution2, expectedSolution2);

    }
}
