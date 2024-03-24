package com.grind75.week2;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;
import com.grind75.common.TreeNode;
import com.grind75.common.VersionControl;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/first-bad-version/
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after
 * a bad version are also bad. Suppose you have n versions [1, 2, ..., n] and you want to
 * find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of
 * calls to the API.
 */
public class FirstBadVersionSolution implements Solution {

    private int solve(VersionControl versionControl) {
        int low = 0;
        int high = versionControl.getNumberOfVersions();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (versionControl.isBadVersion(mid)
                    && !versionControl.isBadVersion(mid - 1)) {
                return mid;
            } else if (!versionControl.isBadVersion(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }


    @Override
    public void run() {
        System.out.println("Running First Bad Version Solution");
        int expectedSolution1 = 4;
        int actualSolution1 = this.solve(new VersionControl(5, 4));
        Comparator.compare(actualSolution1, expectedSolution1);

        int expectedSolution2 = 1;
        int actualSolution2 = this.solve(new VersionControl(1, 1));
        Comparator.compare(actualSolution2, expectedSolution2);
    }
}
