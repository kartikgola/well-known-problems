/*
 * Author: Kartik Gola
 * Date: 8/11/21, 10:07 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] pre = new int[n+1];

        for (int i = 0; i < n; ++i) {
            pre[i+1] = pre[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= n; ++j) {
            ans = Math.min(ans, pre[j] + (n-j-(pre[n] - pre[j])));
        }

        return ans;
    }
}
