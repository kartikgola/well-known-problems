/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class BestTimeToBuyAndSellStockWithCooldown {

    private int f(int[] prices, int i, int hold, Integer[][] dp) {
        if (i >= prices.length)
            return 0;

        if (dp[i][hold] != null)
            return dp[i][hold];

        if (hold == 0) {
            return dp[i][hold] = Math.max(
                    f(prices, i+1, 0, dp),
                    -prices[i] + f(prices, i+1, 1, dp)
            );
        } else {
            return dp[i][hold] = Math.max(
                    f(prices, i+1, 1, dp),
                    prices[i] + f(prices, i+2, 0, dp)
            );
        }
    }

    // Top-down DP solution O(n^2)
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return f(prices, 0, 0, dp);
    }

    // Bottom-up DP solution O(n^2)
    public int maxProfitDP2(int[] prices) {
        final int n = prices.length;
        /*
         * dp[i][j] = max profit achievable starting from ith day with and without holding a stock in hand
         * j = 0 means not holding a stock, 1 means holding a stock
         * dp[i][j] = {
         *   dp[i][0]
         *       max {-prices[j] + dp[i+1][1], dp[i+1][0]}
         *   dp[i][1]
         *       max {prices[i] + dp[i+2][0], dp[i+1][1]}
         * }
         * */
        int[][] dp = new int[n+2][2];
        dp[n-1][0] = Math.max(0, -prices[n-1]);
        dp[n-1][1] = Math.max(0, prices[n-1]);


        for (int i = n-2; i >= 0; --i) {
            // not-holding => keep not-holding OR buy today
            for (int k = i; k < n; ++k) {
                dp[i][0] = Math.max(dp[i][0],
                        Math.max(dp[k+1][0], -prices[i] + dp[k+1][1])
                );
            }
            // holding => keep holding OR sell today
            for (int k = i; k < n; ++k) {
                dp[i][1] = Math.max(dp[i][1],
                        Math.max(dp[k+1][1], prices[i] + dp[k+2][0])
                );
            }
        }

        return dp[0][0];
    }
}
