/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class MinCostClimbingStairs {

    private int climb(int[] cost, Integer[] dp, int i) {
        if (i >= cost.length)
            return 0;
        if (dp[i] != null)
            return dp[i];
        return dp[i] = cost[i] + Math.min(
                climb(cost, dp, i+1),
                climb(cost, dp, i+2)
        );
    }

    public int minCostClimbingStairs(int[] cost) {
        final Integer[] dp = new Integer[cost.length];
        return Math.min(climb(cost, dp, 0), climb(cost, dp, 1));
    }

    public int minCostClimbingStairs2(int[] cost) {
        final int n = cost.length;
        int[] dp = new int[n+2];

        for (int i = n-1; i >= 0; --i) {
            dp[i] = Math.min(Integer.MAX_VALUE, cost[i] + Math.min(dp[i+1], dp[i+2]));
        }

        return Math.min(dp[0], dp[1]);
    }
}
