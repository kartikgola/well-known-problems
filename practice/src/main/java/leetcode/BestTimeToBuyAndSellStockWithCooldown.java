/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * Returns maximum profit for current state (buy, curr)
     * @param prices : array of prices
     * @param buy : buying date (represented by index); -1 means we don't hold any stock; otherwise, we are holding stock bought at prices[buy]
     * @param curr : current date (represented by index)
     * @param dp : 2d array of [buy][curr]
     * @return maximum profit for current state (buy, curr)
     */
    private int f(int[] prices, int buy, int curr, int[][] dp) {
        if (curr >= prices.length)
            return 0;
        if (dp[buy+1][curr+1] != Integer.MIN_VALUE)
            return dp[buy+1][curr+1];
        if (buy == -1) {
            // Skip current date or buy
            return dp[buy+1][curr+1] = Math.max(f(prices, -1, curr+1, dp), f(prices, curr, curr+1, dp));
        } else {
            // Keep holding or sell and continue
            return dp[buy+1][curr+1] = Math.max(f(prices, buy, curr+1, dp), prices[curr]-prices[buy] + f(prices, -1, curr+2, dp));
        }
    }

    // O(n^2) DP solution
    public int maxProfitDP1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] d: dp)
            Arrays.fill(d, Integer.MIN_VALUE);
        return f(prices, -1, 0, dp);
    }

    // O(n) DP solution
    public int maxProfitDP2(int[] prices) {
        final int n = prices.length;
        if (n <= 1)
            return 0;

        // For a given day(index), there are only 2 states possible at the end of the day-
        // 1) Will be holding Stock,
        // 2) Will not be holding Stock
        int[] notHolding = new int[n];
        int[] holding = new int[n];

        // Not holding anything on day 0, we will get 0
        notHolding[0] = 0;
        // Holding on day 0 will give us profit = -prices[0]
        holding[0] = -prices[0];

        // Not holding anything on day 1:
        // 1. PASS and do nothing (same as notHolding[0])
        // 2. SELL the holding in hand
        notHolding[1] = Math.max(notHolding[0], holding[0]+prices[1]);

        // Holding anything on day 1:
        // 1. PASS and make value same as holding[0]
        // 2. BUY new stock
        holding[1] = Math.max(holding[0], -prices[1]);

        for (int i = 2; i < n; ++i) {
            notHolding[i] = Math.max(notHolding[i-1], holding[i-1]+prices[i]);
            holding[i] = Math.max(holding[i-1], notHolding[i-2]-prices[i]);
        }

        return Math.max(notHolding[n-1], holding[n-1]);
    }
}
