/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class KthSmallestInMultiplicationTable {

    // Returns true if numbers <= x are >= k
    private boolean isFeasible(int x, int m, int n, int k) {
        int smaller = 0;
        for (int i = 1; i <= m; ++i) {
            smaller += Math.min(x / i, n);
        }
        return smaller >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m*n;
        while (l < r) {
            int x = l+(r-l)/2;
            if (isFeasible(x, m, n, k)) {
                r = x;
            } else {
                l = x+1;
            }
        }
        return l;
    }
}
