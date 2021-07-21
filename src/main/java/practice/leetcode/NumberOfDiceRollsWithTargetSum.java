/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {

    int[][][] dp;

    private int g(int d, int f, int t) {
        if ( t <= 0 )
            return 0;
        if ( d <= 1 ) {
            if ( t > f )
                return 0;
            return 1;
        }
        if ( dp[d][f][t] > -1 )
            return dp[d][f][t];
        int w = 0;
        for ( int v = 1; v <= f; ++v ) {
            w = (w + g(d - 1, f, t - v)) % 1000_000_007;
        }
        return dp[d][f][t] = w;
    }


    public int numRollsToTarget(int d, int f, int target) {
        this.dp = new int[d + 1][f + 1][target + 1];
        for ( int i = 0; i < d + 1; ++i )
            for ( int j = 0; j < f + 1; ++j )
                Arrays.fill(dp[i][j], -1);
        return g(d, f, target);
    }
}
