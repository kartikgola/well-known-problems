/*
 * Author: Kartik Gola
 * Date: 9/20/21, 1:18 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; ++i)
            sum[i] += sum[i-1] + nums[i];

        // dp[i][j] = min. largest sum in nums[0..i] using j splits
        int[][] dp = new int[n][m];
        for (int[] d: dp)
            Arrays.fill(d, Integer.MAX_VALUE);

        // for 0 splits, dp[i][0] will just be sum[i]
        for (int i = 0; i < n; ++i)
            dp[i][0] = sum[i];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < i; ++k) {
                    // dp[i][j] = min(dp[i][j], max(dp[k][j-1], sum[i]-sum[k]))
                    if (j-1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sum[i]-sum[k]));
                    }
                }
            }
        }

        return dp[n-1][m-1];
    }
}
