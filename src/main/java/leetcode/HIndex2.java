/*
 * Author: Kartik Gola
 * Date: 19/06/20, 1:31 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

public class HIndex2 {

    public int hIndex(int[] ct) {
        final int n = ct.length;
        if ( n == 0 ) return 0;

        int i = 0, j = ct.length - 1;
        while ( i <= j ) {
            int m = i + (j - i) / 2;
            if ( ct[m] < n - m ) {
                i = m + 1;
            } else if ( ct[m] > n - m ) {
                j = m - 1;
            } else {
                return ct[m];
            }
        }

        return Math.min(n - i, i < n ? ct[i] : ct[i - 1]);
    }
}
