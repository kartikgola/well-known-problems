/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
