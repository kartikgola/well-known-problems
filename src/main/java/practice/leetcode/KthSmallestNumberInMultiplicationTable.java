/*
 * Author: Kartik Gola
 * Date: 12/14/21, 10:06 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class KthSmallestNumberInMultiplicationTable {

    private boolean f(int x, int m, int n, int k) {
        int smaller = 0;
        for (int row = 1; row <= m; ++row) {
            smaller += Math.min(x / row, n);
        }
        return smaller >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        // Use binary search with feasibility-check
        // feasibility = count(elements less than equal to mid) >= k
        int l = 1, r = m*n;
        while (l < r) {
            int mid = l+(r-l)/2;
            if (f(mid, m, n, k)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
}
