package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree
 * in which the depth of the two subtrees of every node never
 * differs by more than one.
 */
public class BalancedBinaryTreeSolution implements Solution {

    private boolean solve(TreeNode root) {
        if (root == null) {
            return true;
        }
        return this.getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = this.getHeight(root.left);
        int rightHeight = this.getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public void run() {
        System.out.println("Running Balanced Binary Tree Solution");
        boolean expectedSolution1 = true;
        boolean actualSolution1 = this.solve(TreeNode.fromListAsItIs(Arrays.asList(3, 9, 20, null, null, 15, 7)));
        Comparator.compare(actualSolution1, expectedSolution1);

        boolean expectedSolution2 = false;
        boolean actualSolution2 = this.solve(TreeNode.fromListAsItIs(Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4)));
        Comparator.compare(actualSolution2, expectedSolution2);

        boolean expectedSolution3 = true;
        boolean actualSolution3 = this.solve(TreeNode.fromListAsItIs(List.of()));
        Comparator.compare(actualSolution3, expectedSolution3);
    }
}
