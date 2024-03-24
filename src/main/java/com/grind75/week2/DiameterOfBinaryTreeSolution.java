package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two
 * nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges
 * between them.
 */
public class DiameterOfBinaryTreeSolution implements Solution {

    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        AtomicInteger ans = new AtomicInteger();
        ans.set(0);
        height(root, ans);
        return ans.get();
    }

    private int height(TreeNode root, AtomicInteger ans) {
        if (root == null) {
            return -1;
        }
        int L = height(root.left, ans);
        int R = height(root.right, ans);
        ans.set(Math.max(ans.get(), L + R + 2));
        return  1 + Math.max(L, R);
    }


    @Override
    public void run() {
        System.out.println("Diameter of Binary Solution");
        int expectedSolution1 = 3;
        int actualSolution1 = this.solve(TreeNode.fromListAsItIs(Arrays.asList(1, 2, 3, 4, 5)));
        Comparator.compare(actualSolution1, expectedSolution1);

        int expectedSolution2 = 1;
        int actualSolution2 = this.solve(TreeNode.fromListAsItIs( Arrays.asList(1, 2)));
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
