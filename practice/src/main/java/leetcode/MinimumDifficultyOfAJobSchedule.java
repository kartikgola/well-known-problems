/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class MinimumDifficultyOfAJobSchedule {

    // f(i, j) = min difficulty of job-schedule that starts with ith job on jth day
    private int f(int[] job, Integer[][] dp, int i, int j, int d) {
        if (j >= d) {
            // if there are still pending jobs, they need to be completed on the last day that is, (d-1)th day
            if (i < job.length)
                return Arrays.stream(job, i, job.length).max().orElse(0);
            return 0;
        }

        if (dp[i][j] != null)
            return dp[i][j];

        int diff = job[i];
        int ans = Integer.MAX_VALUE;

        for (int k = i; k < job.length - (d-j) + 1; ++k) {
            diff = Math.max(diff, job[k]);
            ans = Math.min(ans, diff + f(job, dp, k+1, j+1, d));
        }

        return dp[i][j] = ans;
    }

    public int minDifficulty(int[] job, int d) {
        if (job.length < d)
            return -1;
        return f(job, new Integer[job.length][d], 0, 0, d);
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

    // Bottom-up solution O(d*n^2)
    public int minDifficulty3(int[] jobDiff, int d) {
        final int n = jobDiff.length;
        if (n < d)
            return -1;

        // dp[i][j] = min difficulty of job-schedule that starts with ith job on jth day
        // goal is to find dp[0][0], just like in top-down approach
        int[][] dp = new int[n][d];

        for (int[] _dp: dp)
            Arrays.fill(_dp, Integer.MAX_VALUE);

        // fill up base case
        dp[n-1][d-1] = jobDiff[n-1];
        for (int i = n-2; i >= 0; --i) {
            dp[i][d-1] = Math.max(dp[i+1][d-1], jobDiff[i]);
        }

        for (int j = d-2; j >= 0; --j) {
            for (int i = j; i < n-(d-j)+1; ++i) {
                int diff = Integer.MIN_VALUE;
                for (int k = i; k < n-(d-j)+1; ++k) {
                    diff = Math.max(diff, jobDiff[k]);
                    dp[i][j] = Math.min(dp[i][j], diff + dp[k+1][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}
