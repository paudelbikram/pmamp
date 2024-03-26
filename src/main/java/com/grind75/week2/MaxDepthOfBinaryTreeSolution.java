package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.ListNode;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 * A binary tree's maximum depth is the number of nodes along the
 * longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthOfBinaryTreeSolution implements Solution {

    // We could do DFS and BFS.
    // This one is DFS
    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackValue = new Stack<>();
        stackNode.push(root);
        stackValue.push(1);
        int maxDepth = 0;
        while(!stackNode.isEmpty()) {
            TreeNode treeNode = stackNode.pop();
            int temp = stackValue.pop();
            maxDepth = Math.max(temp, maxDepth);
            if (treeNode.left != null) {
                stackNode.push(treeNode.left);
                stackValue.push(temp + 1);
            }
            if (treeNode.right != null) {
                stackNode.push(treeNode.right);
                stackValue.push(temp + 1);
            }
        }
        return maxDepth;
    }
    @Override
    public void run() {
        System.out.println("Max Depth Of Binary Tree Solution");
        TreeNode testTree1 = TreeNode.fromListAsItIs(Arrays.asList(3,9,20,null,null,15,7));
        int expectedSolution1 = 3;
        int actualSolution1 = this.solve(testTree1);
        Comparator.compare(actualSolution1, expectedSolution1);

        TreeNode testTree2 = TreeNode.fromListAsItIs(Arrays.asList(1,null,2));
        int expectedSolution2 = 2;
        int actualSolution2 = this.solve(testTree2);
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
