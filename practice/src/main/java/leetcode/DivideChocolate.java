/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class DivideChocolate {

    // Approach 1 - O(n*K*(n-K)) DP solution
    public int maximizeSweetness(int[] nums, int K) {
        final int n = nums.length;
        final int[][] dp = new int[n][K+1];
        final int[] pre = new int[n];

        pre[0] = nums[0];
        for (int i = 1; i < n; ++i)
            pre[i] += pre[i-1]+nums[i];

        for (int i = 0; i < n; ++i)
            dp[i][0] = pre[i];

        // dp[i][k] = maximum of minimum sweetness among all cut parts using chocolates in [0..i] with k cuts
        for (int i = 0; i < n; ++i) {
            // no. of cuts can be in [1, K] and always have to be <= i
            // example, i = 3, so we are looking at chocolates [10,20,30,40]
            // that means, no. of cuts can be in [1, 3]
            for (int k = 1; k <= K && k <= i; ++k) {
                // "k-1 <= i-j" always makes sure that no. of cuts <= ending index
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

    // Approach 2 - O(log(N)*N) Binary-search solution
    private boolean canSplit(int[] sweetness, int minSum, int k) {
        int cuts = 0;
        int currSum = 0;
        for (int sweet : sweetness) {
            currSum += sweet;
            if (currSum > minSum) {
                currSum = 0;
                cuts++;
                if (cuts > k)
                    return false;
            }
        }
        return true;
    }

    public int maximizeSweetness2(int[] sweetness, int k) {
        // left = minimum one piece sweetness
        // right = sum of all sweetness
        int l = sweetness[0];
        int r = 0;
        for (int num: sweetness) {
            l = Math.min(l, num);
            r += num;
        }

        while (l < r) {
            int mid = l+(r-l)/2;
            if (canSplit(sweetness, mid, k)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }

        return l;
    }
}
