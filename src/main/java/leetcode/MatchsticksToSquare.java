/*
 * Author: Kartik Gola
 * Date: 6/15/21, 4:55 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/matchsticks-to-square/
 */

package leetcode;

import java.util.Arrays;

public class MatchsticksToSquare {

    private boolean canPartition(int[] ms, boolean[] vis, long sum, long target, int k, int st) {
        if (k == 0)
            return true;
        if (sum == target && canPartition(ms, vis, 0, target, k-1, 0))
            return false;
        for (int i = st; i < ms.length; ++i) {
            if (!vis[i] && sum + ms[i] <= target) {
                vis[i] = true;
                if (canPartition(ms, vis, sum+ms[i], target, k, i+1))
                    return true;
                vis[i] = false;
            }
        }
        return false;
    }

    public boolean makesquare(int[] ms) {
        if (ms.length < 4)
            return false;
        long sum = 0;
        for (int v: ms) sum += v;
        if (sum % 4 != 0)
            return false;
        Arrays.sort(ms);
        return canPartition(ms, new boolean[ms.length], 0, sum/4, 4, 0);
    }
}
