/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

package practice.leetcode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0; // buy index
        for (int j = 1; j < prices.length; j++) {
            if (prices[j] < prices[i])
                i = j;
            profit = Math.max(profit, prices[j] - prices[i]);
        }
        return profit;
    }
}
