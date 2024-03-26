package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.ListNode;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list
 * Given the head of a singly linked list, return the middle node
 * of the linked list.
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfLinkedListSolution implements Solution {

    private ListNode solve(ListNode root) {
        int sizeOfListRootNode = root.size();
        if (sizeOfListRootNode == 1) {
            return root;
        }
        int midNodeIndex = (sizeOfListRootNode / 2)  + 1;
        int counter = 1;
        ListNode currentNode = root;
        ListNode solutionRootNode = null;
        while (currentNode != null) {
            if (counter != midNodeIndex) {
                currentNode = currentNode.getNext();
                counter++;
                continue;
            }
            solutionRootNode = currentNode;
            break;
        }
        return solutionRootNode;
    }


    @Override
    public void run() {
        System.out.println("Middle Of LinkedList Solution");
        ListNode testRootNode1 = ListNode.fromListAsItIs(Arrays.asList(1,2,3,4,5), -1);
        ListNode expectedSolution1 = ListNode.fromListAsItIs(Arrays.asList(3,4,5), -1);
        ListNode actualSolution1 = this.solve(testRootNode1);
        Comparator.compare(actualSolution1, expectedSolution1);

        ListNode testRootNode2 = ListNode.fromListAsItIs(Arrays.asList(1,2,3,4,5,6), -1);
        ListNode expectedSolution2 = ListNode.fromListAsItIs(Arrays.asList(4,5,6), -1);
        ListNode actualSolution2 = this.solve(testRootNode2);
        Comparator.compare(actualSolution2, expectedSolution2);

        ListNode testRootNode3 = ListNode.fromListAsItIs(Arrays.asList(1), -1);
        ListNode expectedSolution3 = ListNode.fromListAsItIs(Arrays.asList(1), -1);
        ListNode actualSolution3 = this.solve(testRootNode3);
        Comparator.compare(actualSolution3, expectedSolution3);
    }
}
