/*
 * Author: Kartik Gola
 * Date: 6/23/21, 11:20 AM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 */

package practice.leetcode;

import java.util.*;

public class MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; ++i)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};

        Arrays.sort(jobs, Comparator.comparingInt(j -> j[1]));
        TreeMap<Integer, Integer> dp = new TreeMap<>();

        for (int i = 0; i < jobs.length;) {
            int j = i, maxProfit = Integer.MIN_VALUE;
            do {
                // Profit from current job + Max profit till job start
                int currProfit = jobs[j][2];
                Map.Entry<Integer, Integer> b4Start = dp.floorEntry(jobs[j][0]);
                if (b4Start != null)
                    currProfit += b4Start.getValue();

                // Profit excluding current job (till job end)
                Map.Entry<Integer, Integer> b4End = dp.floorEntry(jobs[j][1]);
                maxProfit = Math.max(maxProfit, b4End != null ? Math.max(b4End.getValue(), currProfit) : currProfit);
                j++;
            } while (j < jobs.length && jobs[j][1] == jobs[i][1]);
            i = j;
            dp.put(jobs[j-1][1], maxProfit);
        }

        return dp.lastEntry().getValue();
    }

    // lee215's solution
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[1]));
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            int cur = job[2] + dp.floorEntry(job[0]).getValue();
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
        return dp.lastEntry().getValue();
    }
}
