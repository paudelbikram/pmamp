package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.ListNode;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Given head, the head of a linked list, determine if the linked list
 * has a cycle in it. There is a cycle in a linked list if there is some
 * node in the list that can be reached again by continuously following
 * the next pointer. Internally, pos is used to denote the index of the
 * node that tail's next pointer is connected to. Note that pos is not
 * passed as a parameter. Return true if there is a cycle in the linked
 * list. Otherwise, return false.
 */
public class LinkedListCycleSolution implements Solution {

    private boolean solve(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode next = head;
        HashMap<Integer, ListNode> hashSet = new HashMap<>();
        while (next != null) {
            if (hashSet.containsKey(next.getVal())) {
                return true;
            }
            hashSet.put(next.getVal(), next);
            next = next.getNext();
        }
        return false;
    }

    @Override
    public void run() {
        System.out.println("Running Linked List Cycle Solution");
        boolean expectedSolution1 = true;
        boolean actualSolution1 = this.solve(ListNode.fromListAsItIs(Arrays.asList(3, 2, 0, -4), 1));
        Comparator.compare(actualSolution1, expectedSolution1);

        boolean expectedSolution2 = true;
        boolean actualSolution2 = this.solve(ListNode.fromListAsItIs(Arrays.asList(1, 2), 0));
        Comparator.compare(actualSolution2, expectedSolution2);

        boolean expectedSolution3 = false;
        boolean actualSolution3 = this.solve(ListNode.fromListAsItIs(List.of(1), -1));
        Comparator.compare(actualSolution3, expectedSolution3);
    }
}
