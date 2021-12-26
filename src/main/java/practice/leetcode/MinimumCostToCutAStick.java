/*
 * Author: Kartik Gola
 * Date: 9/5/21, 12:53 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumCostToCutAStick {

    private Integer[][] memo;

    /*
        cuts[] ==> sorted([0, ...cuts, n])
        dp[i][j] = min cost to use all cuts in (i, j)
        dp[i][j] = cuts[j] - cuts[i] + min {
            dp[i][k] + dp[k][j]
        }; where, k is in [i+1, j)

        Goal is to find dp[0][cuts.length-1]
    */

    private int cost(int i, int j, int[] cuts) {
        if (j - i <= 1)
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];
        memo[i][j] = Integer.MAX_VALUE;
        for (int k = i+1; k < j; ++k) {
            memo[i][j] = Math.min(
                    memo[i][j],
                    cuts[j] - cuts[i] + cost(i, k, cuts) + cost(k, j, cuts)
            );
        }
        return memo[i][j];
    }

    public int minCost(int n, int[] cuts) {
        final int m = cuts.length;
        memo = new Integer[m+2][m+2];
        int[] _cuts = new int[m+2];
        for (int i = 1; i <= m; ++i)
            _cuts[i] = cuts[i-1];
        _cuts[m+1] = n;
        Arrays.sort(_cuts);
        return cost(0, _cuts.length-1, _cuts);
    }

}
