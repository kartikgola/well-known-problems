/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {

    private int[] intersectionOf(int[] x, int[] y) {
        if (x[1] < y[0] || x[0] > y[1])
            return new int[]{};
        return new int[]{Math.max(x[0], y[0]), Math.min(x[1], y[1])};
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> al = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];
            int[] c = intersectionOf(a, b);
            if (c.length == 0) {
                if (a[1] > b[1])
                    j++;
                else
                    i++;
            } else {
                al.add(c);
                if (a[1] >= c[1]) {
                    j++;
                } else if (b[1] > c[1]) {
                    i++;
                } else {
                    i++; j++;
                }
            }
        }

        int[][] ans = new int[al.size()][2];
        for (int k = 0; k < ans.length; ++k)
            ans[k] = al.get(k);

        return ans;
    }

}
