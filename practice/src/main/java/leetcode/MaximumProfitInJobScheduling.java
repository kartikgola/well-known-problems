/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

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

    // based on lee215's solution
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        // sort by endTime in ascending order
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[1]));

        // use treemap to store {end_time = max_profit_till_this_end_time}
        TreeMap<Integer, Integer> dp = new TreeMap<>(){{ put(0, 0); }};

        for (int[] job : jobs) {
            // max profit upto the job that ends before current job's start
            int prev = dp.floorEntry(job[0]).getValue();

            // profit from current job
            int cur = job[2];

            // since we've iterating the jobs in sorted order of endTime, it is guaranteed that next job
            // would have an endTime >= current job's endTime. So, we will only add (cur+prev) to DP if
            // it is higher than lastEntry's profit (since it wouldn't make sense for future jobs to club
            // with a lower profit job -> This step is greedy!)
            if (cur + prev > dp.lastEntry().getValue())
                dp.put(job[1], cur + prev);
        }
        return dp.lastEntry().getValue();
    }
}
