/*
 * Author: Kartik Gola
 * Date: 1/1/22, 11:44 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class MinimumDifficultyOfAJobSchedule {

    // f(i, j) = min difficulty of job-schedule that starts with ith job on jth day
    private int f(int[] jobDiff, Integer[][] dp, int i, int j, int d) {
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
            ans = Math.min(ans, diff + f(jobDiff, dp, k+1, j+1, d));
        }

        return dp[i][j] = ans;
    }

    public int minDifficulty(int[] jobDiff, int d) {
        if (jobDiff.length < d)
            return -1;
        return f(jobDiff, new Integer[jobDiff.length][d], 0, 0, d);
    }


    // Slight optimization of previous approach
    // Since difficulty of a day is max {jobs_for_that_day}, we pre-compute the hardest jobs from right to left
    // f(i, j) = min difficulty of job-schedule that starts with ith job on jth day
    private int f2(int[] jobDiff, int[] hardest, Integer[][] dp, int i, int j, int d) {
        if (j >= d) {
            // if there are still pending jobs, they need to be completed on the last day that is, (d-1)th day
            if (i < jobDiff.length)
                return hardest[i];
            return 0;
        }

        if (dp[i][j] != null)
            return dp[i][j];

        int diff = jobDiff[i];
        int ans = Integer.MAX_VALUE;

        for (int k = i; k < jobDiff.length - (d-j) + 1; ++k) {
            diff = Math.max(diff, jobDiff[k]);
            ans = Math.min(ans, diff + f2(jobDiff, hardest, dp, k+1, j+1, d));
        }

        return dp[i][j] = ans;
    }

    public int minDifficulty2(int[] jobDiff, int d) {
        if (jobDiff.length < d)
            return -1;
        int hardestJob = Integer.MIN_VALUE;
        int[] hardest = new int[jobDiff.length];
        for (int i = jobDiff.length-1; i >= 0; --i) {
            hardestJob = Math.max(hardestJob, jobDiff[i]);
            hardest[i] = hardestJob;
        }
        return f2(jobDiff, hardest, new Integer[jobDiff.length][d], 0, 0, d);
    }
}
