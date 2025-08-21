package com.grind75.common;

import java.util.Arrays;
import java.util.List;

public class Comparator {

    public static void compareIntArray(int[] actual, int[] expected) {
        if (Arrays.equals(actual, expected)) {
            System.out.println("PASSED !!!");
        } else {
            System.out.println("FAILED !!! Expected :" + Arrays.toString(expected) + " Actual : "
                    + Arrays.toString(actual));
        }
    }

    public static<T> void compareListOfList(List<List<T>> actual, List<List<T>> expected) {
        if (actual.equals(expected)) {
            System.out.println("PASSED !!!");
        } else {
            System.out.println("FAILED !!! Expected :" + expected.toString() + " Actual : " + actual.toString());
        }
    }

    public static void compare2DIntArray(int[][] actual, int[][] expected) {
        if (Arrays.deepEquals(actual, expected)) {
            System.out.println("PASSED !!!");
        } else {
            System.out.println("FAILED !!! Expected :" + Arrays.toString(expected) + " Actual : "
                    + Arrays.toString(actual));
        }
    }

    public static <T> void compare(T actual, T expected) {
        if (actual == null && expected == null) {
            System.out.println("PASSED !!!");
            return;
        }
        if (actual == null || expected == null) {
            System.out.println("FAILED !!!");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
            return;
        }
        if (actual.getClass().isPrimitive()) {
            if (actual == expected) {
                System.out.println("PASSED !!!");
            } else {
                System.out.println("FAILED !!!");
                System.out.println("Expected : " + expected);
                System.out.println("Actual   : " + actual);
            }
        } else {
            if (actual.equals(expected)) {
                System.out.println("PASSED !!!");
            } else {
                System.out.println("FAILED !!!");
                System.out.println("Expected : " + expected);
                System.out.println("Actual   : " + actual);
            }
        }
    }
}
