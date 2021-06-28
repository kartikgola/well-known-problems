/*
 * Author: Kartik Gola
 * Date: 12/13/20, 11:44 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/burst-balloons/
 */

package leetcode;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        final int n = nums.length;
        if (n == 0)
            return 0;

        int[][] dp = new int[n][n];
        for (int len = 0; len < n; ++len) {
            for (int i = 0, j = len; i < n - len; ++i, ++j) {
                int maxCoins = 0;
                // kth balloon is gonna burst last
                for (int k = i; k <= j; ++k) {
                    // coins we get after [i...k-1] balloons burst
                    int leftCoins = k - 1 >= i ? dp[i][k - 1] : 0;
                    // coins we get after [k+1...j] balloons burst
                    int rightCoins = k + 1 <= j ? dp[k + 1][j] : 0;

                    // After [i...k-1] and [k+1...j] balloons are burst
                    // we need to find the next available left and right balloons
                    int nextLeftBalloon = i - 1 > -1 ? nums[i - 1] : 1;
                    int nextRightBalloon = j + 1 < n ? nums[j + 1] : 1;

                    maxCoins = Math.max(maxCoins, leftCoins + (nextLeftBalloon * nums[k] * nextRightBalloon) + rightCoins);
                }
                dp[i][j] = maxCoins;
            }
        }

        return dp[0][n - 1];
    }
}
