package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node
 * of two given nodes in the BST. According to the definition of LCA on Wikipedia:
 * The lowest common ancestor is defined between two nodes p and q as the lowest
 * node in T that has both p and q as descendants (where we allow a node to be
 * a descendant of itself).
 */
public class LowestCommonAncestorBinaryTreeSolution implements Solution {


    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currentNode = root;

        while (true) {
            if (p.val < currentNode.val && q.val < currentNode.val) {
                currentNode = currentNode.left;
                continue;
            }
            if (p.val > currentNode.val && q.val > currentNode.val) {
                currentNode = currentNode.right;
                continue;
            }
            break;
        }
        return currentNode;
    }

    @Override
    public void run() {
        System.out.println("Running Lowest Common Ancestor Binary Tree Solution");

        int expectedSolution1 = 6;
        int actualSolution1 = this.solve(TreeNode.fromArray(new int[]{6, 2, 8, 0, 4, 7, 9, 3, 5}),
                new TreeNode(2), new TreeNode(8)).val;
        Comparator.compare(actualSolution1, expectedSolution1);

        int expectedSolution2 = 2;
        int actualSolution2 = this.solve(TreeNode.fromArray(new int[]{6, 2, 8, 0, 4, 7, 9, 3, 5}),
                new TreeNode(2), new TreeNode(4)).val;
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
