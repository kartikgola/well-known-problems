/*
 * Author: Kartik Gola
 * Date: 1/3/22, 5:03 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class BestTimeToBuyAndSellStock4 {

    private Integer[][][] dp;

    private int f(int[] prices, int i, int j, int k) {
        if (k <= 0)
            return 0;

        if (i >= prices.length)
            return 0;

        if (dp[i][j][k] != null)
            return dp[i][j][k];

        if (j == 0) {
            return dp[i][j][k] = Math.max(
                    f(prices, i+1, 0, k),
                    -prices[i] + f(prices, i+1, 1, k)
            );
        } else {
            return dp[i][j][k] = Math.max(
                    f(prices, i+1, 1, k),
                    prices[i] + f(prices, i+1, 0, k-1)
            );
        }
    }

    // Top-down solution in O(2nk)
    public int maxProfit(int k, int[] prices) {
        /*
            1 transaction = buy+sell

            every ith day is attached with 3 state variables -
                holding or not holding a stock
                ith day
                number of transactions remaining

            every day, we can take these actions
                continue to hold
                continue to not-hold
                buy at today's price
                sell previously held

            f(i, j, k)
                ith day
                j=0 => holding, j=1 => not-holding
                k remaining transactions
            => max profit you can achieve if you start from ith day, holding/not-holding a stock, with k remaining transactions

            goal is to f(0, 0, k)
        */
        dp = new Integer[prices.length][2][k+1];
        return f(prices, 0, 0, k);
    }

    // Bottom-up solution in O(2nk)
    public int maxProfit2(int K, int[] prices) {
        final int n = prices.length;
        if (n <= 0)
            return 0;

        // dp[i][j][k] = max profit you can achieve starting from ith day, holding(j=1) or not-holding(j=0) a stock, with k remaining transactions
        int[][][] dp = new int[n][2][K+1];

        // base case
        for (int i = n-1; i >= 0; --i) {
            // not-holding
            for (int k = 1; k <= K; ++k) {
                dp[i][0][k] = 0;
            }
            // holding
            for (int k = 1; k <= K; ++k) {
                dp[i][1][k] = prices[i];
            }
        }

        // recursive case
        for (int i = n-2; i >= 0; --i) {
            // not-holding => buy today OR keep not-holding
            for (int k = 1; k <= K; ++k) {
                dp[i][0][k] = Math.max(
                        -prices[i] + dp[i+1][1][k],
                        dp[i+1][0][k]
                );
            }
            // holding => sell and make profit OR keep holding
            for (int k = 1; k <= K; ++k) {
                dp[i][1][k] = Math.max(
                        prices[i] + dp[i+1][0][k-1],
                        dp[i+1][1][k]
                );
            }
        }

        return dp[0][0][K];
    }
}
