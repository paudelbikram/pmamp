package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

import java.util.Map;
import java.util.Stack;

/**
 * TOPIC : STACK
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParenthesesSolution implements Solution {

    private Map<Character, Character> closeOpenBrackets = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public boolean solveUsingStack(String s) {
        Stack<Character> characterStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            // Close bracket
            if (closeOpenBrackets.containsKey(c)) {
                Character lastChar = characterStack.pop();
                if (!lastChar.equals(closeOpenBrackets.get(c))) {
                    return false;
                }
            } else { // Open bracket
                characterStack.push(c);
            }
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println("Running ValidParentheses Solution");

        boolean firstResultExpected = true;
        boolean firstResult = this.solveUsingStack("()");
        Comparator.compare(firstResult, firstResultExpected);

        boolean secondResultExpected = true;
        boolean secondResult = this.solveUsingStack("()[]{}");
        Comparator.compare(secondResult, secondResultExpected);

        boolean thirdResultExpected = false;
        boolean thirdResult = this.solveUsingStack("(]");
        Comparator.compare(thirdResult, thirdResultExpected);
    }
}
