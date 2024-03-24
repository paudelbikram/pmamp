package com.grind75;

import com.grind75.common.Solution;
import com.grind75.week1.*;
import com.grind75.week2.*;

import java.util.List;

public class Main {
    public static List<Solution> solutions = List.of(
            // Week 1
            new TwoSumSolution(),
            new ValidParenthesesSolution(),
            new MergeTwoSortedListsSolution(),
            new BestTimeToBuyAndSellStockSolution(),
            new ValidPalindromeSolution(),
            new InvertBinaryTreeSolution(),
            new ValidAnagramSolution(),
            new BinarySearchSolution(),
            new FloodFillSolution(),
            new LowestCommonAncestorBinaryTreeSolution(),
            new BalancedBinaryTreeSolution(),
            new LinkedListCycleSolution(),
            new QueueUsingStackSolution(),

            // Week 2
            new FirstBadVersionSolution(),
            new RansomNoteSolution(),
            new ClimbingStairsSolution(),
            new LongestPalindromeSolution(),
            new ReverseLinkedListSolution(),
            new MajorityElementSolution(),
            new AddBinarySolution(),
            new DiameterOfBinaryTreeSolution(),
            new MiddleOfLinkedListSolution()

            // Week 3
    );


    public static void main(String[] args) {
        for (Solution s : solutions) {
            s.run();
        }
    }
}