/*
 * Author: Kartik Gola
 * Date: 8/29/21, 11:29 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cp, int k) {
        final int n = cp.length;
        if (k == 1)
            return Math.max(cp[0], cp[n-1]);

        int[] pre = new int[n];
        pre[0] = cp[0];

        for (int i = 1; i < n; ++i)
            pre[i] = pre[i-1] + cp[i];

        // find min sum sub-array of length 'n-k'
        int sum = Integer.MAX_VALUE;
        for (int start = 0, end = n-k-1; start <= end && end < n; ++start, ++end)
            sum = Math.min(sum, pre[end] - (start > 0 ? pre[start-1] : 0));

        return sum == Integer.MAX_VALUE ? pre[n-1] : pre[n-1] - sum;
    }
}
