/*
 * Author: Kartik Gola
 * Date: 9/5/21, 2:01 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayDeque;

public class PredictTheWinner {

    // Approach - You(P1) can only win if you can put your opponent(P2) in a situation where his choices don't matter.
    // That means, both the branches of recursion for your opponent should make him lose.
    // returns true if score of P1 >= score of P2
    // turn = true, means it is P1's turn
    private boolean f(int[] nums, boolean turn, int p1, int p2, int l, int r) {
        if (l == r) {
            if (turn)
                p1 += nums[l];
            else
                p2 += nums[l];
            return p1 >= p2;
        }
        if (turn) {
            // You can win by using left OR right
            return f(nums, false, nums[l] + p1, p2, l + 1, r) || f(nums, false, nums[r] + p1, p2, l, r - 1);
        }
        // Opponent needs to lose using both left AND right
        return f(nums, true, p1, nums[l]+p2, l+1, r) && f(nums, true, p1, nums[r]+p2, l, r-1);
    }

    public boolean PredictTheWinner(int[] nums) {
        return f(nums, true, 0, 0, 0, nums.length-1);
    }

    // Approach - Any player can only take out left/right from nums
    // dp[i][j] = max score of "P1" using piles from [i...j]
    // P1's turn => dp[i][j] = max{ nums[i] + dp[i+1][j], nums[j] + dp[i][j-1] }
    // P2's turn => dp[i][j] = min{ -nums[i] + dp[i+1][j], -nums[j] + dp[i][j-1] }
    public boolean PredictTheWinnerDP(int[] nums) {
        final int n = nums.length;
        boolean evenStart = n % 2 == 0;
        int[][] dp = new int[n][n];

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n-k; ++i) {
                int j = i+k;
                boolean p1turn;
                int len = j-i+1;
                if (evenStart) {
                    p1turn = len % 2 == 0;
                } else {
                    p1turn = len % 2 != 0;
                }
                if (i == j)
                    dp[i][j] = (p1turn ? 1 : -1) * nums[i];
                else if (p1turn)
                    dp[i][j] = Math.max(nums[i] + dp[i+1][j], nums[j] + dp[i][j-1]);
                else
                    dp[i][j] = Math.min(-nums[i] + dp[i+1][j], -nums[j] + dp[i][j-1]);
            }
        }

        return dp[0][n-1] >= 0;
    }
}
