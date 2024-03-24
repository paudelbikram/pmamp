package com.grind75.week1;

import com.grind75.common.Comparator;
import com.grind75.common.Solution;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * You are given an array prices where prices[i] is the price of a given
 * stock on the ith day. You want to maximize your profit by choosing a single day
 * to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot
 * achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStockSolution implements Solution {

    public int solve(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i] - prices[j] > maxProfit) {
                    maxProfit = prices[i] - prices[j];
                }
            }
        }
        return maxProfit;
    }

    @Override
    public void run() {
        System.out.println("Running Best Time To By And Sell Stock Solution");
        int expectedSolution = 5;
        int actualSolution = this.solve(new int[]{7, 1, 5, 3, 6, 4});
        Comparator.compare(actualSolution, expectedSolution);

        int expectedSolution1 = 0;
        int actualSolution1 = this.solve(new int[]{7, 6, 4, 3, 1});
        Comparator.compare(actualSolution1, expectedSolution1);
    }
}
