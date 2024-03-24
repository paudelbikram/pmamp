package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTreeSolution implements Solution {

    private void recursivelyInvert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        this.recursivelyInvert(root.right);
        this.recursivelyInvert(root.left);
    }

    private TreeNode solve(TreeNode root) {
        this.recursivelyInvert(root);
        return root;
    }


    private TreeNode makeInvertedTreeNode(int[] a) {
        if (a.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(a[0]);
        for (int i = 1; i < a.length; i++) {
            TreeNode current = root;
            while (true) {
                if (current.val < a[i]) {
                    TreeNode left = current.left;
                    if (left == null) {
                        current.left = new TreeNode(a[i]);
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    TreeNode right = current.right;
                    if (right == null) {
                        current.right = new TreeNode(a[i]);
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }

        }
        return root;
    }


    @Override
    public void run() {
        System.out.println("Running Invert Binary Tree Solution");
        TreeNode expectedSolution = this.makeInvertedTreeNode(new int[]{4, 7, 2, 9, 6, 3, 1});
        TreeNode actualSolution = this.solve(TreeNode.fromArray(new int[]{4, 2, 7, 1, 3, 6, 9}));
        Comparator.compare(actualSolution, expectedSolution);

        TreeNode expectedSolution1 = this.makeInvertedTreeNode(new int[]{2, 3, 1});
        TreeNode actualSolution1 = this.solve(TreeNode.fromArray(new int[]{2, 1, 3}));
        Comparator.compare(actualSolution1, expectedSolution1);

        TreeNode expectedSolution2 = this.makeInvertedTreeNode(new int[]{});
        TreeNode actualSolution2 = this.solve(TreeNode.fromArray(new int[]{}));
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
