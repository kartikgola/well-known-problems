/*
 * Author: Kartik Gola
 * Date: 12/16/21, 10:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class MaximumScoreFromPerformingMultiplicationOperations {

    Integer[][] dp;

    private int f(int[] a, int[] b, int l, int k) {
        if (k == b.length)
            return 0;
        int r = (a.length-1) - (k - l);
        if (dp[l][k] != null)
            return dp[l][k];
        return dp[l][k] = Math.max(
                a[l] * b[k] + f(a, b, l+1, k+1),
                a[r] * b[k] + f(a, b, l, k+1)
        );
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        // since max left value is always limited to m, we use dp of [m][m]
        dp = new Integer[multipliers.length][multipliers.length];
        return f(nums, multipliers, 0, 0);
    }
}
