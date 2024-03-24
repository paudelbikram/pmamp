package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.ListNode;
import com.grind75.common.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue
 * (push, peek, pop, and empty).
 * Implement the MyQueue class:
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 */
public class QueueUsingStackSolution implements Solution {
    @Override
    public void run() {
        System.out.println("Running Queue Using Stack Solution");
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        Comparator.compare(queue.peek(), 1);
        Comparator.compare(queue.pop(), 1);
        Comparator.compare(queue.empty(), false);
    }


    public static class MyQueue {
        private final Stack<Integer> inputStack;
        private final Stack<Integer> outputStack;

        public MyQueue() {
            this.inputStack = new Stack<>();
            this.outputStack = new Stack<>();
        }

        public void push(int x) {
            if (inputStack.empty()) {
                while (!outputStack.empty()) {
                    inputStack.push(outputStack.pop());
                }
                inputStack.push(x);
            } else {
                inputStack.push(x);
            }
        }

        public int pop() {
            if (inputStack.empty()) {
                return outputStack.pop();
            } else {
                while (!inputStack.empty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.pop();
        }

        public int peek() {
            if (inputStack.empty()) {
                return outputStack.peek();
            } else {
                while (!inputStack.empty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.peek();
        }

        public boolean empty() {
            return inputStack.empty() && outputStack.empty();
        }
    }
}
