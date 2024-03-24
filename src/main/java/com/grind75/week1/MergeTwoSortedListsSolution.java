package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.Objects;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedListsSolution implements Solution {


    public ListNode solve(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode root = null;
        ListNode currentList1Node = list1;
        ListNode currentList2Node = list2;
        if (currentList1Node.val < currentList2Node.val) {
            root = new ListNode(currentList1Node.val);
            currentList1Node = currentList1Node.next;
        } else {
            root = new ListNode(currentList2Node.val);
            currentList2Node = currentList2Node.next;
        }


        ListNode currentNode = root;

        while (true) {
            if (currentList1Node == null) {
                currentNode.next = currentList2Node;
                break;
            }
            if (currentList2Node == null) {
                currentNode.next = currentList1Node;
                break;
            }
            if (currentList1Node.val < currentList2Node.val) {
                currentNode.next = new ListNode(currentList1Node.val);
                currentList1Node = currentList1Node.next;
            } else {
                currentNode.next = new ListNode(currentList2Node.val);
                currentList2Node = currentList2Node.next;
            }
            currentNode = currentNode.next;
        }
        return root;
    }

    public ListNode makeListNode(int[] arr) {
        if (arr.length == 0) {
            // let's denote empty List Node as -1 because constraints is 0 - 50
            return null;
        }
        ListNode root = new ListNode(arr[0]);
        ListNode current = root;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return root;
    }

    @Override
    public void run() {
        System.out.println("Running Merge Two Sorted List Solution");
        ListNode secondResultExpected = makeListNode(new int[]{});
        ListNode secondResult = this.solve(this.makeListNode(new int[]{}), this.makeListNode(new int[]{}));
        Comparator.compare(secondResult, secondResultExpected);

        ListNode thirdResultExpected = makeListNode(new int[]{0});
        ListNode thirdResult = this.solve(this.makeListNode(new int[]{}), this.makeListNode(new int[]{0}));
        Comparator.compare(thirdResult, thirdResultExpected);

        ListNode firstResultExpected = this.makeListNode(new int[]{1, 1, 2, 3, 4, 4});
        ListNode firstResult = this.solve(this.makeListNode(new int[]{1, 2, 4}), this.makeListNode(new int[]{1, 3, 4}));
        Comparator.compare(firstResult, firstResultExpected);


    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}



