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
     *  1. Use 1 less color and combine with f(n-1, k)
     *  2. Use 1 less color and combine with f(n-2, k)
     *     For the 2nd part, think of it like this -
     *     if n = 3, k = 3, and assuming f(1) is painted with r, g, b
     *     that means, there are these posts available with us
     *     r, _, ?
     *     g, _, ?
     *     b, _, ?
     *
     *     so, each, '?' can have 2 ways to color it, (1 less color, that is, k-1)
     *     r, _, b/g
     *     g, _, r/b
     *     b, _, g/r
     *
     *     now, the '_' part can be filled in 2 ways as well
     *     r, b/g, b/g
     *     g, r/b, r/b
     *     b, g/r, g/r
     *
     *     so, we have 6 ways, that forms our 2nd term => (k-1) * f(n-2, k)
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
