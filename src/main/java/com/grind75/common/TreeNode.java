package com.grind75.common;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode fromListAsItIs(List<Integer> a) {
        if (a.size() == 0) {
            return null;
        }

        if (a.size() <= 3) {
            TreeNode root = new TreeNode(a.get(0));
            root.left = (a.size() >= 2 && a.get(1) != null) ? new TreeNode(a.get(1)) : null;
            root.right = (a.size() == 3 && a.get(2) != null) ? new TreeNode(a.get(2)) : null;
            return root;
        }

        TreeNode root = new TreeNode(a.get(0));
        root.left = new TreeNode(a.get(1));
        root.right = new TreeNode(a.get(2));

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        nodeList.add(root.left);
        nodeList.add(root.right);
        int currentIndex = 1;
        for (int i = 3; i < a.size(); i = i + 2) {
            TreeNode current = nodeList.size() > currentIndex ? nodeList.get(currentIndex) : null;
            if (current == null) {
                break;
            }
            current.left = a.get(i) != null ? new TreeNode(a.get(i)) : null;
            current.right = a.size() > (i + 1) && a.get(i + 1) != null ? new TreeNode(a.get(i + 1)) : null;
            currentIndex = currentIndex + 1;
            nodeList.add(current.left);
            nodeList.add(current.right);
        }
        return root;
    }

    public static TreeNode fromArray(int[] a) {
        if (a.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(a[0]);
        for (int i = 1; i < a.length; i++) {
            TreeNode current = root;
            while (true) {
                if (current.val < a[i]) {
                    TreeNode right = current.right;
                    if (right == null) {
                        current.right = new TreeNode(a[i]);
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    TreeNode left = current.left;
                    if (left == null) {
                        current.left = new TreeNode(a[i]);
                        break;
                    } else {
                        current = current.left;
                    }
                }
            }

        }
        return root;
    }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}
