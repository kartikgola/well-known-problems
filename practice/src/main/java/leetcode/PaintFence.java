/*
 * Author: Kartik Gola
 * Date: 1/23/22, 8:40 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class PaintFence {

    private Integer[][] memo;

    /**
     *  f(n, k) = no of ways to color 'n' posts using 'k' colors
     *  f(n, k) = {
     *      k, if n == 1
     *      k*k, if n == 2,
     *      (k-1) * (f(n-1,k) + f(n-2,k))
     *  }
     *
     *  At each ith post -
     *  1. We can use a different color as (i-1)th post
     *  2. We can use a same color as (i-1)th post, provided (i-2)th post is of different color
     *
     *  Total colors = k
     *  So, no. of ways to paint ith post using a different color than (i-1)th post = (k-1) * f(n-1)
     *  Also, by the same logic, no. of ways to paint (i-2)th post using a different color than (i-1)th post = (k-1) * f(n-2)
     *
     *  So, Total ways = (k-1) * (f(n-1) + f(n-2))
     *      where n >= 3,
     *            k >= 1
     */
    private int f(int n, int k) {
        if (n == 1)
            return k;
        if (n == 2)
            return k*k;
        if (memo[n][k] != null)
            return memo[n][k];
        return memo[n][k] = (k-1) * (f(n-1, k) + f(n-2, k));
    }

    public int numWays(int n, int k) {
        memo = new Integer[n+1][k+1];
        return f(n, k);
    }
}
