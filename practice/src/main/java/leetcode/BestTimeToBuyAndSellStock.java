/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

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
