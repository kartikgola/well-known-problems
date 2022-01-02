/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlices2Subsequence {

    public int numberOfArithmeticSlices(int[] a) {
        final int n = a.length;
        int ans = 0;
        // dp[i][j] = length of arithmetic subsequence ending at 'i', having common diff. 'j'
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = (long)a[i]-a[j];
                if (d < Integer.MIN_VALUE || d > Integer.MAX_VALUE)
                    continue;
                int di = (int)d;
                dp.putIfAbsent(j, new HashMap<>());
                int prev = dp.get(j).getOrDefault(di, 0);

                dp.putIfAbsent(i, new HashMap<>());
                int curr = dp.get(i).getOrDefault(di, 0);

                dp.get(i).put(di, curr + prev + 1);

                // There are 'prev' number of arithmetic subsequences on which we will append a[i]
                // So, we count only those 'prev' no. of arithmetic sequences to form ans.
                ans += prev;
            }
        }
        return ans;
    }
}
