package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.ListNode;
import com.grind75.common.Solution;

import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Given the head of a singly linked list, reverse the list,
 * and return the reversed list.
 */
public class ReverseLinkedListSolution implements Solution {

    private ListNode solve(ListNode node) {
        if (node == null) {
            return null;
        }
        Stack<Integer> integerStack = new Stack<>();
        ListNode currentNode = node;
        do {
            integerStack.push(currentNode.getVal());
            currentNode = currentNode.getNext();
        } while (currentNode != null);

        ListNode reverseRoot = new ListNode(integerStack.pop());
        ListNode nextNode = reverseRoot;
        while (!integerStack.empty()) {
            ListNode loopNode = new ListNode(integerStack.pop());
            nextNode.setNext(loopNode);
            nextNode = loopNode;
        }
        return reverseRoot;
    }

    @Override
    public void run() {
        System.out.println("Running Reverse Linked List Solution");
        ListNode expectedSolution1 = ListNode.fromListAsItIs(List.of(5, 4, 3, 2, 1), -1);
        ListNode actualSolution1 = this.solve(ListNode.fromListAsItIs(List.of(1, 2, 3, 4, 5), -1));
        Comparator.compare(actualSolution1, expectedSolution1);

        ListNode expectedSolution2 = ListNode.fromListAsItIs(List.of(2, 1), -1);
        ListNode actualSolution2 = this.solve(ListNode.fromListAsItIs(List.of(1, 2), -1));
        Comparator.compare(actualSolution2, expectedSolution2);

        ListNode expectedSolution3 = ListNode.fromListAsItIs(List.of(), -1);
        ListNode actualSolution3 = ListNode.fromListAsItIs(List.of(), -1);
        Comparator.compare(actualSolution3, expectedSolution3);
    }
}
