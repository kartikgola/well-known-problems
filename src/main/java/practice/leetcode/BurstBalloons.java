/*
 * Author: Kartik Gola
 * Date: 12/13/20, 11:44 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/burst-balloons/
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private Integer[][] dp;

    private int f(int i, int j, List<Integer> nums) {
        if (j - i <= 1)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = 0;
        for (int k = i+1; k < j; ++k) {
            // coins we get if kth balloon is last to burst
            int coins = nums.get(i) * nums.get(k) * nums.get(j);
            coins += f(i, k, nums) + f(k, j, nums);
            ans = Math.max(ans, coins);
        }
        return dp[i][j] = ans;
    }

    // Top-down solution similar to MinimumCostToCutAStick
    public int maxCoins2(int[] nums) {
        final int n = nums.length;
        List<Integer> _nums = new ArrayList<>();
        _nums.add(1);
        _nums.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        _nums.add(1);
        dp = new Integer[_nums.size()][_nums.size()];
        return f(0, _nums.size()-1, _nums);
    }
}
