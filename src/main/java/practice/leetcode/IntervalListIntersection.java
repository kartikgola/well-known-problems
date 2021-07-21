/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {

    private boolean isIntersecting(int[] a, int[] b) {
        return a[1] >= b[0] && b[1] >= a[0];
    }

    private int[] getIntersection(int[] a, int[] b) {
        return new int[]{ Math.max(a[0], b[0]), Math.min(a[1], b[1]) };
    }

    private boolean isSmaller(int[] a, int[] b) {
        return a[1] <= b[1];
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        final int m = A.length;
        final int n = B.length;
        List<List<Integer>> res = new ArrayList<>(m);

        int i = 0, j = 0;
        while ( i < m && j < n ) {
            if ( isIntersecting(A[i], B[j]) ) {
                int[] temp = getIntersection(A[i], B[j]);
                res.add( Arrays.asList( temp[0], temp[1] ) );
            }
            if ( isSmaller(A[i], B[j]) ) {
                ++i;
            } else {
                ++j;
            }
        }

        if ( res.size() == 0 )
            return new int[][]{};

        int w = 0;
        int[][] resArr = new int[res.size()][2];
        for ( List<Integer> r : res ) {
            resArr[ w ][0] = r.get(0);
            resArr[ w++ ][1] = r.get(1);
        }

        return resArr;
    }

}
