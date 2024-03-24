package com.grind75.common;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ListNode {
    private final int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static ListNode fromListAsItIs(List<Integer> integerList, int circularIndex) {
        if (integerList.size() == 0) {
            return null;
        }
        HashMap<Integer, ListNode> nodeHashMap = new HashMap<>();
        ListNode root = new ListNode(integerList.get(0));
        nodeHashMap.put(0, root);
        ListNode current = root;
        for (int i = 1; i < integerList.size(); i++) {
            current.next = new ListNode(integerList.get(i));
            nodeHashMap.put(i, current.next);
            current = current.next;
        }

        // build circular link
        if (circularIndex != -1) {
            current.next = nodeHashMap.get(circularIndex);
        }
        return root;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int size() {
        int size = 1;
        ListNode root = this;
        while (root.next != null) {
            size++;
            root = root.next;
        }
        return size;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
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
}
