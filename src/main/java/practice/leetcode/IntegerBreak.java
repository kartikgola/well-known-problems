/*
 * Author: Kartik Gola
 * Date: 21/07/20, 8:15 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j <= i; j ++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    Map<Integer, Integer> dp = new HashMap<>();

    private int f(int n) {
        if ( n <= 1 )
            return 1;

        if ( dp.containsKey(n) )
            return dp.get(n);

        int prod = 1;
        for ( int i = 1; i <= n; ++i )
            prod = Math.max(prod, i * f(n - i));

        dp.put(n, prod);
        return prod;
    }

    public int integerBreakRecursive(int n) {
        int prod = 1;
        for ( int i = 1; i < n; ++i ) {
            prod = Math.max(prod, i * f(n - i));
        }
        return prod;
    }
}
