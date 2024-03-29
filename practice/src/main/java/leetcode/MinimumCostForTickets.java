/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class MinimumCostForTickets {

    final int[] pass = new int[]{1, 7, 15};

    // Subtract pass[j] number of days from the current day, days[i]
    // and return the index of greatest day which is LTE to days[i] - pass[j]
    private int floorDayIndex(int[] days, int i, int j) {
        while (i > -1) {
            if (days[i] <= days[i] - pass[j])
                return i;
            i--;
        }
        return -1;
    }

    // cost(i) denotes the minimum cost to complete all days in [0, i]
    // using all permutations of passes (costs)
    // cost(i) = min{cost(i - floorIndex(days[i] - pass[j])) + costs[j]}
    //           for all j in [0, 2]
    //           where pass[] = [1, 7, 15]
    private int cost(int[] days, int[] costs, int[] dp, int i) {
        if (i < 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < costs.length; ++j) {
            int cost = cost(days, costs, dp, floorDayIndex(days, i, j)) + costs[j];
            minCost = Math.min(minCost, cost);
        }
        return dp[i] = minCost;
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return cost(days, costs, dp, days.length - 1);
    }
}
