/*
 * Author: Kartik Gola
 * Date: 6/15/21, 4:55 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/matchsticks-to-square/
 */

package practice.leetcode;

import java.util.Arrays;

public class MatchsticksToSquare {

    private boolean makesquare(int[] a, boolean[] vis, int begin, long sum, long target, int parts) {
        if (parts == 0)
            return true;
        if (sum == target && makesquare(a, vis, a.length-1, 0, target, parts-1))
            return true;
        for (int i = begin; i >= 0; i--) {
            if (!vis[i] && a[i]+sum <= target) {
                vis[i] = true;
                if (makesquare(a, vis, i-1, a[i]+sum, target, parts))
                    return true;
                vis[i] = false;
            }
        }
        return false;
    }

    public boolean makesquare(int[] a) {
        if (a.length < 4)
            return false;
        long sum = 0;
        for (int v: a) sum += v;
        if (sum % 4 != 0)
            return false;
        // Sorting here is being done to speed up the process of grouping
        // Since a big number, if taken first, is less probable to be grouped with other numbers
        Arrays.sort(a);
        return makesquare(a, new boolean[a.length], a.length-1, 0, sum/4, 4);
    }
}
