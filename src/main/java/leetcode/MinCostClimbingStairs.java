/*
 * Author: Kartik Gola
 * Date: 6/7/21, 7:49 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/min-cost-climbing-stairs/
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
}
