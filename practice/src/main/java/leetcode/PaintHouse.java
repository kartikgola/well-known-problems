/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class PaintHouse {

    private final Integer[][] dp = new Integer[101][3];

    private int minCost(int[][] costs, int i, int p) {
        if (i == costs.length)
            return 0;
        if (p != -1 && dp[i][p] != null)
            return dp[i][p];
        int cost = Integer.MAX_VALUE;
        for (int c = 0; c <= 2; ++c)
            if (p == -1 || c != p)
                cost = Math.min(cost, costs[i][c] + minCost(costs, i+1, c));
        return p != -1 ? (dp[i][p] = cost) : cost;
    }

    public int minCost(int[][] costs) {
        return minCost(costs, 0, -1);
    }

}
