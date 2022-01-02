/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class MaximumScoreFromPerformingMultiplicationOperations {

    Integer[][] dp;

    private int f(int[] nums, int[] mult, int l, int op) {
        if (op == mult.length)
            return 0;
        int r = (nums.length-1) - (op - l);
        if (dp[l][op] != null)
            return dp[l][op];
        return dp[l][op] = Math.max(
                nums[l] * mult[op] + f(nums, mult, l+1, op+1),
                nums[r] * mult[op] + f(nums, mult, l, op+1)
        );
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        final int m = multipliers.length;
        // since max value of left value is always limited to m, we use dp of [m][m]
        dp = new Integer[m][m];
        return f(nums, multipliers, 0, 0);
    }

    public int maximumScore2(int[] nums, int[] multipliers) {
        final int n = nums.length;
        final int m = multipliers.length;

        // dp[l][op] = max score when left is l and current operation is op
        // goal is to find dp[0][m-1]
        int[][] dp = new int[m+1][m+1];

        // start looping from the base case of top-down approach
        for (int l = m-1; l >= 0; --l) {
            for (int op = m-1; op >= l; --op) {
                int r = (n-1) - (op-l);
                dp[l][op] = Math.max(
                        nums[l] * multipliers[op] + dp[l+1][op+1],
                        nums[r] * multipliers[op] + dp[l][op+1]
                );
            }
        }

        // just like we return f(0, 0) in top-down, we return dp[0][0] here
        return dp[0][0];
    }
}
