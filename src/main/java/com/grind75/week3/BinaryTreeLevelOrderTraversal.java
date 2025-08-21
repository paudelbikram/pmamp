package com.grind75.week3;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal implements Solution {

    public List<List<Integer>> solve(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return new ArrayList<>();
        }
        if (nums.size() == 1) {
            return List.of(List.of(nums.get(0)));
        }
        TreeNode root = TreeNode.fromListAsItIs(nums);
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> levelQueue = new PriorityQueue<>();
        assert root != null;
        res.add(List.of(root.val));
        levelQueue.add(root);

        while(!levelQueue.isEmpty()) {
            ArrayList<Integer> currentLevelChilds = new ArrayList<>();
            int sizeOfQueue = levelQueue.size();
            for (int i = 0; i < sizeOfQueue; i++) {
                TreeNode currentLevelNode = levelQueue.poll();
                assert currentLevelNode != null;
                if (currentLevelNode.left != null) {
                    currentLevelChilds.add(currentLevelNode.left.val);
                    levelQueue.add(currentLevelNode.left);
                }
                if (currentLevelNode.right != null) {
                    currentLevelChilds.add(currentLevelNode.right.val);
                    levelQueue.add(currentLevelNode.right);
                }
            }
            if (!currentLevelChilds.isEmpty()) {
                res.add(currentLevelChilds);
            }
        }
        return res;
    }


    @Override
    public void run() {
        System.out.println("Binary Tree Level Order Traversal Solution");
        List<Integer> testInput1 = Arrays.asList(3,9,20,null,null,15,7);
        List<List<Integer>> expectedSolution1 = Arrays.asList(List.of(3), List.of(9,20), List.of(15,7));
        List<List<Integer>> actualSolution1 = this.solve(testInput1);
        Comparator.compareListOfList(actualSolution1, expectedSolution1);

        List<Integer> testInput2 = List.of(1);
        List<List<Integer>> expectedSolution2 = List.of(List.of(1));
        List<List<Integer>> actualSolution2 = this.solve(testInput2);
        Comparator.compareListOfList(actualSolution2, expectedSolution2);

        List<Integer> testInput3 = List.of();
        List<List<Integer>> expectedSolution3 = List.of();
        List<List<Integer>> actualSolution3 = this.solve(testInput3);
        Comparator.compareListOfList(actualSolution3, expectedSolution3);
    }
}
