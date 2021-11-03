/*
 * Author: Kartik Gola
 * Date: 11/3/21, 2:58 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class DivideChocolate {

    public int maximizeSweetness(int[] nums, int K) {
        final int n = nums.length;
        final int[][] dp = new int[n][K+1];
        final int[] pre = new int[n];

        pre[0] = nums[0];
        for (int i = 1; i < n; ++i)
            pre[i] += pre[i-1]+nums[i];

        for (int i = 0; i < n; ++i)
            dp[i][0] = pre[i];

        // O(n*K*(n-K)) solution
        // dp[i][k] = maximum of minimum sweetness among all cut parts using chocolates in [0..i] with k cuts
        for (int i = 0; i < n; ++i) {
            // no. of cuts can be in [1, K] and always have to be LTE i
            for (int k = 1; k <= K && k <= i; ++k) {
                for (int j = 1; i-j >= 0 && k-1 <= i-j; ++j) {
                    dp[i][k] = Math.max(dp[i][k],
                        Math.min(pre[i]-pre[i-j],
                            dp[i-j][k-1]
                        )
                    );
                }
            }
        }

        return dp[n-1][K];
    }
}
