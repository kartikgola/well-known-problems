/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        final int n = prices.length;
        int prev = 0;

        // leftProfit[i] = max profit for 1 transaction in prices[0..i]
        int[] leftProfit = new int[n];
        for (int i = 1; i < n; ++i) {
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i]-prices[prev]);
            if (prices[prev] > prices[i]) {
                prev = i;
            }
        }

        prev = n-1;
        // rightProfit[i] = max profit for 1 transaction in prices[i..n-1]
        int[] rightProfit = new int[n];
        for (int i = n-2; i >= 0; --i) {
            rightProfit[i] = Math.max(rightProfit[i+1], prices[prev]-prices[i]);
            if (prices[prev] < prices[i])
                prev = i;
        }

        int ans = Math.max(leftProfit[n-1], rightProfit[0]);
        for (int i = 0; i < n-1; ++i) {
            ans = Math.max(ans, leftProfit[i] + rightProfit[i+1]);
        }

        return ans;
    }
}
