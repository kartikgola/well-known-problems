/*
 * Author: Kartik Gola
 * Date: 1/1/22, 11:44 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class MinimumDifficultyOfAJobSchedule {

    private Integer[][] dp;

    // f(i, j) = min difficulty of job-schedule that starts with ith job on jth day
    private int f(int[] jobDiff, int i, int j, int d) {
        if (j >= d) {
            // if there are still pending jobs, they need to be completed on the last day that is, (d-1)th day
            if (i < jobDiff.length) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k < jobDiff.length; ++k)
                    max = Math.max(max, jobDiff[k]);
                return max;
            }
            return 0;
        }

        if (dp[i][j] != null)
            return dp[i][j];

        int diff = jobDiff[i];
        int ans = Integer.MAX_VALUE;

        for (int k = i; k < jobDiff.length - (d-j) + 1; ++k) {
            diff = Math.max(diff, jobDiff[k]);
            ans = Math.min(ans, diff + f(jobDiff, k+1, j+1, d));
        }

        return dp[i][j] = ans;
    }

    public int minDifficulty(int[] jobDiff, int d) {
        if (jobDiff.length < d)
            return -1;
        dp = new Integer[jobDiff.length][d];
        return f(jobDiff, 0, 0, d);
    }
}
