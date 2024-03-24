package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

/**
 * https://leetcode.com/problems/add-binary/
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinarySolution implements Solution {

    private String solve(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            int sum = carry;
            if (bIndex >= 0) {
                int numberAtBIndex = Character.getNumericValue(b.charAt(bIndex));
                sum = sum + numberAtBIndex;
                bIndex--;
            }
            if (aIndex >= 0) {
                int numberAtAIndex = Character.getNumericValue(a.charAt(aIndex));
                sum = sum + numberAtAIndex;
                aIndex--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    @Override
    public void run() {
        System.out.println("Add Binary Solution");
        String expectedSolution1 = "100";
        String actualSolution1 = this.solve("11", "1");
        Comparator.compare(actualSolution1, expectedSolution1);

        String expectedSolution2 = "10101";
        String actualSolution2 = this.solve("1010", "1011");
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
