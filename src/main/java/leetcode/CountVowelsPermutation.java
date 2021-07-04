/*
 * Author: Kartik Gola
 * Date: 7/4/21, 7:25 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CountVowelsPermutation {

    int[][] dp;
    final int mod = 1000_000_007;
    Map<Integer, List<Integer>> vowels = Map.of(
            0, Arrays.asList(1),
            1, Arrays.asList(0, 2),
            2, Arrays.asList(0, 1, 3, 4),
            3, Arrays.asList(2, 4),
            4, Arrays.asList(0)
    );

    private int count(int n, int p) {
        if (n == 0)
            return 1;
        if (dp[n][p] > 0)
            return dp[n][p];
        int c = 0;
        for (int next: vowels.get(p)) {
            c += count(n-1, next);
            c %= mod;
        }
        return dp[n][p] = c;
    }

    public int countVowelPermutation(int n) {
        dp = new int[n][5];
        int c = 0;
        for (int i = 0; i < 5; ++i) {
            c += count(n-1, i);
            c %= mod;
        }
        return c;
    }
}
